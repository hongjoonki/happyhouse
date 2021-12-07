package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.UserDto;

public interface UserService {

	public UserDto login(UserDto userDto) throws Exception;
	public UserDto userInfo(String userid) throws Exception;
	public List<UserDto> userList(String user_id) throws Exception;
	public boolean idCheck(String user_id) throws Exception;
	public boolean signUp(UserDto userDto) throws Exception;
	public boolean userDelete(String user_id) throws Exception;
	public boolean userModify(UserDto userDto) throws Exception;
}
