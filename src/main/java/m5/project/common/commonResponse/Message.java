package m5.project.common.commonResponse;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Message<T> {
	
	private HttpStatus status;
	private T data;
	private String message;
	
	
}
