package m5.project.models.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	public int insertUser(UserDto user);
	
	
}
