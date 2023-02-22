package m5.project.models.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	public int insertUser(UserDto user);

	public Optional<UserDto> findByMemId(UserDto user);

}
