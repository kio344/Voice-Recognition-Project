package m5.project.models.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import m5.project.common.commonResponse.ClientError;

@Service
public class UserService {

	public UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {

		this.userDao = userDao;

	}

	public UserDto joinProcess(UserDto joinRequest) {

		// 기존 회원이 쓰는 아이디 인지 확인
		Optional<UserDto> dupUserCk = userDao.findByMemId(joinRequest);

		if (!dupUserCk.isEmpty()) {
			throw new ClientError("이미 존재하는 아이디 입니다.", HttpStatus.PRECONDITION_FAILED);
		}

		userDao.insertUser(joinRequest);

		return joinRequest;
	}

}
