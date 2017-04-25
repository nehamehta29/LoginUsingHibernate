package loginApp;

import java.util.List;


import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {
	
	private SessionFactory sessionFactory;
	
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	public boolean authenicateUser(String username,String password)
	{
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String sql = "select * from user where USER_NAME=? and USER_PASS=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List list = query.list();
		if(list!=null && list.size()>0)
		{
			userFound = true;
		}
		session.close();
		return userFound;
	}
	
	
	
	
	
	
	
	public boolean registerUser(User user)
	{
		//Configuration configuration = new Configuration();
		//configuration.configure("hibernate.cfg.xml");
		
		//SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		tx.commit();
		System.out.println("Details Added");
		return true;
		
		
	}

	




	

	
	
	
	
	
	
}
