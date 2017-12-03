package com.slurp.web.hibernate.dao;

import com.slurp.web.dao.hibernateDAO.HibernateDAOFactory;
import com.slurp.web.dao.interfaces.UserDAO;

public abstract class DAOFactory {
	
	private static DAOFactory daoFactory = null;
	
	protected DAOFactory() {
		
	}
	
	public static DAOFactory getInstance() {
		if(daoFactory == null) {
			synchronized (HibernateDAOFactory.class) {
				if(daoFactory == null)
					daoFactory = new HibernateDAOFactory();
			}
		}
		return daoFactory;
	}
	
	public abstract UserDAO getUserDAO();
}
