package m5.project.models.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;

@Getter @Setter @ToString
public class PostDto extends BaseDto  {
	
	private Integer postId;
	private Integer borderId;
	private Integer userId;
	private String title;
	private String content;
	private Integer views;
	private Integer good;
	private Integer commentCk;
	
	

}
