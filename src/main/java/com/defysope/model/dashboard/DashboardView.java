package com.defysope.model.dashboard;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONObject;

import org.apache.commons.lang.BooleanUtils;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.defysope.utils.NumberUtils;
import com.defysope.utils.StringUtils;

@Entity
@Table(name = "dashboard_view")
public class DashboardView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dashboard_view_cid_gen")
	@SequenceGenerator(name = "dashboard_view_cid_gen", sequenceName = "dashboard_view_cid_seq")
	@Column(name = "cid")
	private int id;

	private int userId;

	@ManyToOne(targetEntity = DashboardType.class, fetch = FetchType.EAGER)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@JoinColumn(name = "typeName")
	private DashboardType type;

	@ManyToOne(targetEntity = DashboardItem.class)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@JoinColumn(name = "item")
	private DashboardItem item;

	@Column(name = "rowNumber")
	private int row;

	@Column(name = "columnNumber")
	private int column;

	private int height;

	@Column(name = "viewOptions")
	private String options;

	@Transient
	private Map<String, String> optionsMap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public DashboardType getType() {
		return type;
	}

	public void setType(DashboardType type) {
		this.type = type;
	}

	public DashboardItem getItem() {
		return item;
	}

	public void setItem(DashboardItem item) {
		this.item = item;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public void setOptionsMap(Map<String, String> optionsMap) {
		this.optionsMap = optionsMap;
	}

	private JSONObject getOptionsJson() {
		return StringUtils.isBlank(options) ? null : JSONObject
				.fromObject(options);
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getOptionsMap() {
		if (optionsMap != null) {
			return optionsMap;
		}
		JSONObject json = getOptionsJson();
		if (json == null) {
			return null;
		}

		synchronized (this) {
			if (optionsMap == null) {
				optionsMap = (Map<String, String>) JSONObject.toBean(json,
						Map.class);
			}
		}

		return optionsMap;
	}

	public String getOption(String key) {
		Map<String, String> map = getOptionsMap();
		return map == null ? null : map.get(key);
	}

	public String getOption(String key, String defaultValue) {
		String option = getOption(key);
		return StringUtils.isBlank(option) ? defaultValue : option;
	}

	public boolean getOptionBoolean(String key, boolean defaultValue) {
		String option = getOption(key);
		return StringUtils.isBlank(option) ? defaultValue : BooleanUtils
				.toBoolean(option);
	}

	public int getOptionInteger(String key, int defaultValue) {
		String option = getOption(key);
		return StringUtils.isBlank(option) ? defaultValue : NumberUtils.toInt(
				option, defaultValue);
	}
}
