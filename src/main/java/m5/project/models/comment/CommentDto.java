package m5.project.models.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;

@Getter @Setter @ToString
public class CommentDto extends BaseDto {
	
	private Integer commentId;
	private Integer postId;
	private Integer userId;
	
	private String content;
	
	

}
