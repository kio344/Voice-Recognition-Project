package m5.project.models.user;

import java.util.Optional;

import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import m5.project.common.commonResponse.ClientError;
import m5.project.models.jwt.JWTService;

@Service
public class UserService {

	public UserDao userDao;
	
	public JWTService jwtService;

	@Autowired
	public UserService(UserDao userDao,JWTService jwtService) {

		this.userDao = userDao;
		
		this.jwtService=jwtService;

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
		
		joinData.setPwd(BCrypt.hashpw(joinData.getPwd(), BCrypt.gensalt(10)));

		userDao.insertUser(joinData);

		return joinData;
	}
	
	public String loginProcess(UserDto user ) {
		
		Optional<UserDto> findUser = userDao.findByMemId(user);
		
		findUser.orElseThrow(() -> new ClientError("존재하지 않는 유저입니다..",HttpStatus.BAD_REQUEST,null));
		
		
		if (!BCrypt.checkpw(user.getPwd(), findUser.get().getPwd())) {
			throw new ClientError("존재하지 않는 유저입니다..",HttpStatus.BAD_REQUEST,null);
		}
		
		System.out.println(findUser);
		
		String token = jwtService.makeJwtToken(findUser.get());
		
		
		
		
		return token;
	}

}
