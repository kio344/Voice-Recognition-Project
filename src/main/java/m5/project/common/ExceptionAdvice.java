package m5.project.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import m5.project.common.commonResponse.ClientError;
import m5.project.common.commonResponse.Message;


@RestControllerAdvice(basePackages = "m5.project.controllers")
public class ExceptionAdvice {
	
	@ExceptionHandler(ClientError.class)
	public ResponseEntity<Message> handleNoData(ClientError e) {
		
		Message<Object> resposneData = new Message<>();

		resposneData.setStatus(e.getErrorCode());
		resposneData.setMessage(e.getMessage());
		resposneData.setData(e.getData());
		
		
		return ResponseEntity
			.status(resposneData.getStatus())
			.body(resposneData);
	}

}
