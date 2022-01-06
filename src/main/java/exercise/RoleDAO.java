package exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RoleDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    void insert(Role role) {
	Session session = sessionFactory.openSession();
	try {
	
	    session.beginTransaction();
	
	    session.save(role);
	
	    session.getTransaction().commit();
	    System.out.println("insert success!");
	} catch (RuntimeException e) {
	
	    session.getTransaction().rollback();
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}

    }
}
