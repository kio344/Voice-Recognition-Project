package m5.project.controllers.userController;

import org.apache.catalina.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m5.project.common.commonResponse.Message;
import m5.project.models.user.UserDto;
import m5.project.models.user.UserService;

@RestController
@RequestMapping("/user")
public class JoinController {

	private UserService userService = null;

	public JoinController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/join")
	public ResponseEntity<Message<UserDto>> joinPs(UserDto joinRequest) {

		System.out.println(joinRequest);

		Message<UserDto> responseMessage = new Message<>();

		HttpHeaders headers = new HttpHeaders();

		UserDto resultData = userService.joinProcess(joinRequest);

		responseMessage.setData(resultData);

		responseMessage.setStatus(HttpStatus.OK);

		return new ResponseEntity<Message<UserDto>>(responseMessage, headers, HttpStatus.OK);

	}

}
