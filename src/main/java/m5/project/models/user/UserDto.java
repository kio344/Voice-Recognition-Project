package m5.project.models.user;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;

@Getter
@Setter
@ToString
public class UserDto extends BaseDto {
	
	private Integer userId;
	private String memId;
	private String pwd;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private Integer kakaoId;
	
	public static UserDto toDto(JoinRequest joinRequest) {
		
		UserDto dto=new UserDto();
		
		dto.setAddress(joinRequest.getAddress());
		dto.setEmail(joinRequest.getEmail());
		dto.setMemId(joinRequest.getMemId());
		dto.setMobile(joinRequest.getMobile());
		dto.setName(joinRequest.getName());
		dto.setPwd(joinRequest.getPwd());
		
		return dto;
		
		
	}

}
