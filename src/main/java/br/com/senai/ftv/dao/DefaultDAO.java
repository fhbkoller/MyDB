package br.com.senai.ftv.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.senai.ftv.util.HibernateUtil;

public class DefaultDAO {

	private Session session;

	protected void beginSession() {
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}

	protected void save(Object entity) {
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
	}

	protected void delete(Object entity) {
		session.delete(entity);
		session.getTransaction().commit();
	}

	protected Query createQuery(String hql) {
		return session.createQuery(hql);
	}

	protected void endSession() {
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
