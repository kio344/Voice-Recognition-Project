package m5.project.models.file;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import m5.project.common.BaseDto;

@Getter @Setter @ToString
public class FileDto extends BaseDto {
	
	private Integer fileId;
	private Integer postId;
	private String name;
	private String originalName;
	private String type;
	private Long size;
	private String path;
	
	
	
}
