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


}
