package m5.project.common.commonResponse;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientError extends RuntimeException {
	
	private HttpStatus errorCode = HttpStatus.OK;

	
	public ClientError(String message,HttpStatus status) {
		super(message);
		this.errorCode=status;
	}
	public ClientError() {
		super("클라이언트 측 오류 입니다");
		this.errorCode=HttpStatus.BAD_REQUEST;
	}
	
	
}
