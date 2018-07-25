package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void flushNCommit(Session session, Transaction tr) {
		if (session != null)
			session.flush();
		if (tr != null)
			tr.commit();
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}
}
