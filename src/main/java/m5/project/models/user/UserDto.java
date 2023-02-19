package m5.project.models.user;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;

@Getter @Setter @ToString
public class UserDto extends BaseDto {

	private Integer userId;
	private String memId;
	private String pwd;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private Integer kakaoId;

	
	
	
	
}
