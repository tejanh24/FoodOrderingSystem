package com.slurp.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.slurp.web.dao.hibernateDAO.HibernateConnector;
import com.slurp.web.dao.interfaces.UserDAO;
import com.slurp.web.dao.model.Authorities;
import com.slurp.web.dao.model.User;

@Component
public class UserImpl implements UserDAO {

	@Override
	public void save(User user, String role) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			session.beginTransaction();
			user.getRoles().add(saveAuthorities(user.getUsername(), role));
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	public Authorities saveAuthorities(String userName, String role) {
		Session session = null;
		Authorities auth = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			auth = new Authorities();
			auth.setUserName(userName);
			auth.setRole(role);
			session.beginTransaction();
			session.save(auth);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return auth;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Query query = session.createQuery(" from User where username = :username");
			query.setParameter("username", userName);
			List<User> userList = query.list();
			if (userList.size() > 0)
				return userList.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
