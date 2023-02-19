package m5.project.controllers.testController;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m5.project.models.user.UserDao;
import m5.project.models.user.UserDto;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserDao userDao;

	@GetMapping
	public UserDto test() {
		
		UserDto user=new UserDto();
		
		user.setEmail("jmspon33@gmail.com");
		user.setMemId("5563a");
		user.setMobile("01075175563");
		user.setName("정민상");
		user.setPwd("123456789");
		user.setAddress("address");
		user.setReg_dt(LocalDateTime.now());
		
		userDao.insertUser(user);
		
		
		return user;
		
		
	}
	
	
	
	
	
}
