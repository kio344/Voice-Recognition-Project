package m5.project.models.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class JoinRequest {

	@NotBlank
	private String memId;
	@NotBlank
	private String pwd;
	@NotBlank
	private String name;
	@NotBlank @Email
	private String email;
	@NotBlank
	private String mobile;
	@NotBlank
	private String address;
	
}
