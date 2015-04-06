package com.defysope.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterDisposer;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.jdbc.support.JdbcUtils;

import com.defysope.dao.Page;

public class JdbcPage implements Page {

	protected List elements;

	protected int pageSize;

	protected int pageNumber;

	protected int totalElements = 0;

	private JdbcPage(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public boolean isFirstPage() {
		return getPageNumber() == 0;
	}

	public boolean isLastPage() {
		return getPageNumber() >= getLastPageNumber();
	}

	public boolean hasNextPage() {
		return getNextPageNumber() <= getLastPageNumber();
	}

	public boolean hasPreviousPage() {
		return getPageNumber() > 0;
	}

	public int getLastPageNumber() {
		double totalResults = new Integer(getTotalNumberOfElements())
				.doubleValue();
		return (new Double(Math.ceil(totalResults / getPageSize())).intValue() - 1);
	}

	public List getThisPageElements() {
		return elements;
	}

	public int getTotalNumberOfElements() {
		return totalElements;
	}

	public int getThisPageFirstElementNumber() {
		return getPageNumber() * getPageSize() + 1;
	}

	public int getThisPageLastElementNumber() {
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalNumberOfElements() < fullPage ? getTotalNumberOfElements()
				: fullPage;
	}

	public int getNextPageNumber() {
		return getPageNumber() + 1;
	}

	public int getPreviousPageNumber() {
		return getPageNumber() - 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public static JdbcPage getJdbcPageInstance(final JdbcTemplate template,
			final String sql, final int pageNumber, final int pageSize,
			final RowMapper mapper) {
		return (JdbcPage) template.execute(new ConnectionCallback() {

			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				JdbcPage page = new JdbcPage(pageNumber, pageSize);

				Statement stmt = null;
				ResultSet rs = null;

				try {
					stmt = conn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					stmt.setFetchSize(pageSize);
					rs = stmt.executeQuery(sql);

					int pageNo = pageNumber < 0 ? 0 : pageNumber;
					int position = pageNo * pageSize;
					if (position != 0) {
						rs.absolute(position);
					} else {
						position = 1;
					}

					List values = new ArrayList();
					int rowCount = 0;
					while (rs.next() && rowCount++ < pageSize) {
						Object obj = mapper.mapRow(rs, rowCount);
						values.add(obj);
					}
					rs.last();

					page.elements = values;
					page.totalElements = rs.getRow();

				} catch (SQLException ex) {
					throw template.getExceptionTranslator().translate(
							"Error while building jdbc page!", sql, ex);
				} finally {
					JdbcUtils.closeResultSet(rs);
					JdbcUtils.closeStatement(stmt);
				}
				return page;
			}
		});
	}

	public static JdbcPage getJdbcPageInstance(final JdbcTemplate template,
			final String sql, final int pageNumber, final int pageSize,
			final Object[] args) {
		return getJdbcPageInstance(template, sql, pageNumber, pageSize,
				new ColumnMapRowMapper(), args);
	}

	public static JdbcPage getJdbcPageInstance(final JdbcTemplate template,
			final String sql, final int pageNumber, final int pageSize,
			final RowMapper mapper, final Object[] args) {
		return (JdbcPage) template.execute(new ConnectionCallback() {

			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				JdbcPage page = new JdbcPage(pageNumber, pageSize);

				PreparedStatement stmt = null;
				ResultSet rs = null;

				try {
					stmt = conn.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					stmt.setFetchSize(pageSize);

					if (args != null && args.length > 0) {
						new ArgPreparedStatementSetter(args).setValues(stmt);
					}

					rs = stmt.executeQuery();

					int pageNo = pageNumber < 0 ? 0 : pageNumber;
					int position = pageNo * pageSize;
					if (position != 0) {
						rs.absolute(position);
					} else {
						position = 1;
					}

					List values = new ArrayList();
					int rowCount = 0;
					while (rs.next() && rowCount++ < pageSize) {
						Object obj = mapper.mapRow(rs, rowCount);
						values.add(obj);
					}
					rs.last();

					page.elements = values;
					page.totalElements = rs.getRow();

				} catch (SQLException ex) {
					throw template.getExceptionTranslator().translate(
							"Error while building jdbc page!", sql, ex);
				} finally {
					JdbcUtils.closeResultSet(rs);
					JdbcUtils.closeStatement(stmt);
				}
				return page;
			}
		});
	}

	/**
	 * Simple adapter for PreparedStatementSetter that applies a given array of
	 * arguments.
	 * 
	 * @author Juergen Hoeller
	 */
	static private class ArgPreparedStatementSetter implements
			PreparedStatementSetter, ParameterDisposer {

		private final Object[] args;

		/**
		 * Create a new ArgPreparedStatementSetter for the given arguments.
		 * 
		 * @param args
		 *            the arguments to set
		 */
		public ArgPreparedStatementSetter(Object[] args) {
			this.args = args;
		}

		public void setValues(PreparedStatement ps) throws SQLException {
			if (this.args != null) {
				for (int i = 0; i < this.args.length; i++) {
					Object arg = this.args[i];
					doSetValue(ps, i + 1, arg);
				}
			}
		}

		/**
		 * Set the value for prepared statements specified parameter index using
		 * the passed in value. This method can be overridden by sub-classes if
		 * needed.
		 * 
		 * @param ps
		 *            the PreparedStatement
		 * @param parameterPosition
		 *            index of the parameter position
		 * @param argValue
		 *            the value to set
		 * @throws SQLException
		 */
		protected void doSetValue(PreparedStatement ps, int parameterPosition,
				Object argValue) throws SQLException {
			if (argValue instanceof SqlParameterValue) {
				SqlParameterValue paramValue = (SqlParameterValue) argValue;
				StatementCreatorUtils.setParameterValue(ps, parameterPosition,
						paramValue, paramValue.getValue());
			} else {
				StatementCreatorUtils.setParameterValue(ps, parameterPosition,
						SqlTypeValue.TYPE_UNKNOWN, argValue);
			}
		}

		public void cleanupParameters() {
			StatementCreatorUtils.cleanupParameters(this.args);
		}

	}
}
