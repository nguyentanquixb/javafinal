package exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    void insert(Employee employee) {
	Session session = sessionFactory.openSession();
	try {

	    session.beginTransaction();

	    session.save(employee);

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
