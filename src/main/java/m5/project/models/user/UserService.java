package m5.project.models.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import m5.project.common.commonResponse.ClientError;

@Service
public class UserService {

	public UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {

		this.userDao = userDao;

	}

	public UserDto joinProcess(JoinRequest joinRequest,Errors errors) {
		
		if(errors.hasErrors()) {
			throw new ClientError("비어있는 값이 존재합니다..",HttpStatus.BAD_REQUEST,errors.getAllErrors());
		}
		
		UserDto joinData = UserDto.toDto(joinRequest);

		// 기존 회원이 쓰는 아이디 인지 확인
		Optional<UserDto> dupUserCk = userDao.findByMemId(joinData);

		if (!dupUserCk.isEmpty()) {
			throw new ClientError("이미 존재하는 아이디 입니다.", HttpStatus.PRECONDITION_FAILED,null);
		}

		userDao.insertUser(joinData);

		return joinData;
	}

}
