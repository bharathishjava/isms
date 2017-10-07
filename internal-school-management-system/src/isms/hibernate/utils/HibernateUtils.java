package isms.hibernate.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private HibernateUtils() {
	}

	private static final SessionFactory sessionFactory = setSessionFactory();

	private static SessionFactory setSessionFactory() {
		Configuration config = new Configuration();
		config.configure();
		return config.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
