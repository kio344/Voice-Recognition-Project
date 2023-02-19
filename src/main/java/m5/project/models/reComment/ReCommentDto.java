package m5.project.models.reComment;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;

@Getter @Setter @ToString
public class ReCommentDto extends BaseDto {
	
	private Integer reCommentId;
	private Integer userId;
	private Integer commentId;
	private Integer borderId;
	private String content;

}
