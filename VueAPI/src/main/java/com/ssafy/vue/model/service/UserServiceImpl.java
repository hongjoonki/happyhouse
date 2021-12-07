package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.UserDto;
import com.ssafy.vue.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if(userDto.getUser_id() == null || userDto.getUser_password() == null)
			return null;
		return sqlSession.getMapper(UserMapper.class).login(userDto);
	}

	@Override
	public UserDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userInfo(userid);
	}

	@Override
	public List<UserDto> userList(String user_id) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userList(user_id);
	}

	@Override
	public boolean idCheck(String user_id) throws Exception {
		return sqlSession.getMapper(UserMapper.class).idCheck(user_id) == 1;
	}

	@Override
	public boolean signUp(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).signUp(userDto) == 1;
	}

	@Override
	public boolean userDelete(String user_id) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userDelete(user_id) == 1;
	}

	@Override
	public boolean userModify(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userModify(userDto) == 1;
	}

}
