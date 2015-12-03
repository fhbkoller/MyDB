package br.com.senai.ftv.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	private static SessionFactory buildSessionAnnotationFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("google-hibernate.cfg.xml");
//			configuration.configure("hibernate.cfg.xml");
			System.out.println("Hibernate Annotation Configuration loaded");

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
			System.out.println("Hibernate Annotation serviceRegistry created");

			SessionFactory sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);

			return sessionFactory;
		} catch (Throwable ex) {
			// TODO Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionAnnotationFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionAnnotationFactory();
		return sessionFactory;
	}

}
