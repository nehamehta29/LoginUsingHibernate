package loginApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Util {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
		UserDAO dao = context.getBean("userDAO",UserDAO.class);
		User user = new User(5,"mayank","pass","mayank@yahoo.com");
		dao.registerUser(user);

	}

}
