package m5.project.controllers.userController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m5.project.models.user.UserDto;
import m5.project.models.user.UserService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	private UserService userService;
	
	public LoginController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginPs(@RequestBody UserDto user){
		
		String userToken = userService.loginProcess(user);
		
		return ResponseEntity.ok(userToken);
	}
	
}
