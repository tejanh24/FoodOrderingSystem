package com.slurp.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.slurp.web.dao.hibernateDAO.HibernateConnector;
import com.slurp.web.dao.interfaces.HotelsDAO;
import com.slurp.web.dao.model.Hotels;

public class HotelsImpl implements HotelsDAO {

	@Override
	public List<Hotels> getListOfHotels() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Query query = session.createQuery(" from Hotels");
			List<Hotels> hotelsList = query.list();
			return hotelsList;
		} catch (Exception e) {

		}
		return null;
	}

}
