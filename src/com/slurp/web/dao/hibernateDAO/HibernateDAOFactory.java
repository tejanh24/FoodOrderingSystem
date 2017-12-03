package com.slurp.web.dao.hibernateDAO;

import com.slurp.web.dao.impl.UserImpl;
import com.slurp.web.dao.interfaces.UserDAO;
import com.slurp.web.hibernate.dao.DAOFactory;

public class HibernateDAOFactory extends DAOFactory {

	private UserDAO userDAO;

	/**
	 * Spring provides singleton classes by default so this wouldn't 
	 * be necessary.(I guess!!!)
	 */
	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		if (userDAO == null) {
			synchronized (UserImpl.class) {
				if (userDAO == null)
					userDAO = new UserImpl();
			}
		}
		return userDAO;
	}

}
