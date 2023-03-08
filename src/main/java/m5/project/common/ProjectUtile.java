package m5.project.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import m5.project.models.jwt.JWTService;
import m5.project.models.user.UserDto;

@Component
public class ProjectUtile {

	private JWTService jwtService;
	
	@Autowired
	public ProjectUtile(JWTService jwtService) {
		this.jwtService=jwtService;
	}
	
	
	/**
	 * 
	 * 헤더에 있는 authorization 값을 읽어서 UserDto 를 가져옵니다
	 * memId,name,userId 값이 저장되어있습니다.
	 * 
	 * @author 5563a
	 * @param requestHeader
	 * @return
	 */
	public UserDto getLoginUser( Map<String, Object> requestHeader) {
		
		UserDto loginUser= null;
		try {
			Claims result = jwtService.parseJwtToken((String)requestHeader.get("authorization"));
			
			loginUser= new UserDto();
			
			loginUser.setMemId((String)result.get("memId"));
			loginUser.setName((String)result.get("name"));
			loginUser.setUserId((Integer)result.get("userId"));
			
		} catch (Exception e) {
			loginUser= null;		
		}
		
		
		
		return loginUser; 
	}
	
}
