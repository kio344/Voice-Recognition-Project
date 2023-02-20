package m5.project.controllers.testController;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m5.project.common.commonResponse.ClientError;
import m5.project.common.commonResponse.Message;
import m5.project.common.commonResponse.StatusEnum;
import m5.project.models.border.BorderDto;
import m5.project.models.user.UserDao;
import m5.project.models.user.UserDto;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserDao userDao;

//	@GetMapping
//	public UserDto test(@ ) {
//		
//		UserDto user=new UserDto();
//		
//		user.setEmail("jmspon33@gmail.com");
//		user.setMemId("5563a");
//		user.setMobile("01075175563");
//		user.setName("정민상");
//		user.setPwd("123456789");
//		user.setAddress("address");
//		user.setReg_dt(LocalDateTime.now());
//		
//		userDao.insertUser(user);
//		
//		
//		return user;
//		
//		
//	}
//	
	@GetMapping
	public ResponseEntity<Message> BoardList(boolean err) {
		Message<String> message = new Message<>();

		HttpHeaders headers = new HttpHeaders();

		// 서비스 메서드 S

		
		if (err) {
			throw new ClientError("권한오류!!", HttpStatus.FORBIDDEN);

		}

		message.setStatus(HttpStatus.OK);
		message.setMessage("성공!!");
		message.setData("성공적인 데이터!!");

		// 서비스 메서드 E

		return new ResponseEntity<Message>(message, headers, HttpStatus.OK);
	}

}
