package com.defysope.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.defysope.dao.DashboardDao;
import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardItem;
import com.defysope.model.dashboard.DashboardView;

@Repository
public class DashboardDaoImpl extends BaseDaoImpl implements DashboardDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DashboardView> getViews(User user, String type) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				DashboardView.class, "view");
		criteria.createAlias("view.item", "vitem");
		criteria.createAlias("view.type", "vtype");
		criteria.createAlias("vitem.types", "vitypes");
		criteria.add(Restrictions.eq("view.userId",
				(user == null ? 0 : user.getId())));
		criteria.add(Restrictions.eq("vtype.name", type));
		criteria.add(Restrictions.eq("vitypes.name", type));
		criteria.addOrder(Order.asc("row"));
		criteria.addOrder(Order.asc("column"));
		@SuppressWarnings("unchecked")
		List<DashboardView> list = criteria.list();
		return list;
	}

	@Override
	public DashboardItem getItem(String type, String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				DashboardItem.class, "item");
		criteria.createAlias("item.types", "itype");
		criteria.add(Restrictions.eq("itype.name", type));
		criteria.add(Restrictions.eq("item.name", name));
		return (DashboardItem) criteria.uniqueResult();
	}

	@Override
	public DashboardView getView(User user, String type, String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				DashboardView.class, "view");
		criteria.createAlias("view.item", "vitem");
		criteria.createAlias("view.type", "vtype");
		criteria.add(Restrictions.eq("view.userId",
				(user == null ? 0 : user.getId())));
		criteria.add(Restrictions.eq("vtype.name", type));
		criteria.add(Restrictions.eq("vitem.name", name));
		return (DashboardView) criteria.uniqueResult();
	}

	@Override
	public List<DashboardItem> getItems(String type) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				DashboardItem.class, "item");
		criteria.createAlias("item.types", "itype");
		criteria.add(Restrictions.eq("itype.name", type));
		criteria.addOrder(Order.asc("caption"));
		@SuppressWarnings("unchecked")
		List<DashboardItem> list = criteria.list();
		return list;
	}

	@Override
	public void moveRowAtAndAfter(User user, String type, int row,
			int positions, int ignoreView) {
		String hql = "update DashboardView v set row = row + :positions where v.userId = :userId and row >= :row"
				+ " and v.id != :ignoreView and v.type.name like :type";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("positions", positions);
		query.setInteger("userId", (user == null ? 0 : user.getId()));
		query.setString("type", type);
		query.setInteger("row", row);
		query.setInteger("ignoreView", ignoreView);
		query.executeUpdate();

	}

	@Override
	public List<DashboardView> getViews(User user, String type, int row) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				DashboardView.class, "view");
		criteria.createAlias("view.item", "vitem");
		criteria.createAlias("view.type", "vtype");
		criteria.add(Restrictions.eq("view.userId",
				(user == null ? 0 : user.getId())));
		criteria.add(Restrictions.eq("vtype.name", type));
		criteria.add(Restrictions.eq("view.row", row));

		@SuppressWarnings("unchecked")
		List<DashboardView> list = criteria.list();
		return list;
	}

	@Override
	public void deleteRow(User user, String type, int row, int ignoreView) {
		String hql = "delete from DashboardView as v where v.userId = :userId and v.row = :row and v.id != :ignoreView"
				+ " and v.type.name like :type";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("userId", (user == null ? 0 : user.getId()));
		query.setString("type", type);
		query.setInteger("row", row);
		query.setInteger("ignoreView", ignoreView);
		query.executeUpdate();
		moveRowAtAndAfter(user, type, row, -1, ignoreView);

	}

}
