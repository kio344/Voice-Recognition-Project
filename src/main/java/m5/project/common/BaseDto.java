package m5.project.common;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public abstract class BaseDto {

	private LocalDateTime regDt;
	private LocalDateTime modDt;
	
	
}
