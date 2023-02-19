package m5.project.models.border;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;


@Getter @Setter @ToString
public class BorderDto extends BaseDto {
	
	private Integer borderId;
	private String name;
	private Integer postCk;
	private Integer commentCk;
	
	
	
	
}
