package com.slurp.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.slurp.web.dao.hibernateDAO.HibernateConnector;
import com.slurp.web.dao.interfaces.HotelsDAO;
import com.slurp.web.dao.model.Hotels;

@Component
public class HotelsImpl implements HotelsDAO {

	@Override
	public List<String> getListOfHotels() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Query query = session.createQuery("select hotelName from Hotels");
			List<String> hotelsList = query.list();
			if (hotelsList.size() > 0)
				return hotelsList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Hotels> getHotelsByMerchantID(int merchantID) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Query query = session.createQuery(" from Hotels where merchantID = :merchantId");
			query.setParameter("merchantId", new Integer(merchantID));
			List<Hotels> hotelsList = query.list();
			if (hotelsList.size() > 0)
				return hotelsList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Hotels hotel) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			session.save(hotel);
			session.getTransaction().commit();
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
