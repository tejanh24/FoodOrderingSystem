package com.slurp.web.dao.hibernateDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

	private Configuration cfg = null;
	private SessionFactory factory = null;
	private static HibernateConnector me = null;

	private HibernateConnector() {
		cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
	}

	public static HibernateConnector getInstance() {
		if (me == null)
			me = new HibernateConnector();
		return me;
	}

	public Session getSession() {
		return factory.openSession();
	}
}
