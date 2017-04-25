package loginApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@Autowired
	UserDAO dao;
	
	@RequestMapping(value="/login.html")
	public ModelAndView loginUser()
	{
		ModelAndView model = new ModelAndView("login");
		return model;
		
	}
	
	
	@RequestMapping(value="/submitLoginDetails.html",method=RequestMethod.POST)
	public ModelAndView authenticateUser(@RequestParam("username") String userName,@RequestParam("password")String userPass)
	{
		
		ModelAndView model = new ModelAndView("success");
		model.addObject("msg", "Details Submitted:" + userName + "Password:" +userPass);
		return model;
		
	}
	
	@RequestMapping(value="/register.html")
	public ModelAndView welcomeUser()
	{
		ModelAndView model = new ModelAndView("register");
		return model;
		
	}
	
	@RequestMapping(value="/submitRegisterDetails.html",method=RequestMethod.POST)
	public ModelAndView registerUser(@RequestParam("id") int userId,@RequestParam("username") String userName,
									@RequestParam("password")String userPass,@RequestParam("email")String userEmail)
	{
		System.out.println(userId + " "+userName + " "+userPass+" "+userEmail);
		User user = new User(userId,userName,userPass,userEmail);
		
		boolean status = dao.registerUser(user);
		if(status==true)
		{
			ModelAndView model = new ModelAndView("success");
			model.addObject("msg", "Details Submitted:" + userName + "Password:" +userPass);
			return model;
		}
		else
		{
			ModelAndView model = new ModelAndView("error");
			return model;
			
		}
	
	}

}
