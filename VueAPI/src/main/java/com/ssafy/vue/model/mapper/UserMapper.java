package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.UserDto;

@Mapper
public interface UserMapper {

	public UserDto login(UserDto userDto) throws SQLException;
	public UserDto userInfo(String userid) throws SQLException;
	public List<UserDto> userList(String user_id) throws SQLException;
	public int idCheck(String user_id);
	public int signUp(UserDto userDto);
	public int userDelete(String user_id) throws SQLException;
	public int userModify(UserDto userDto) throws SQLException;
	
}
