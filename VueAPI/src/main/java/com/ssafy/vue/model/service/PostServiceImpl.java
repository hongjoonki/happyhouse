package com.ssafy.vue.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.CaptionDto;
import com.ssafy.vue.model.PostCaptionDto;
import com.ssafy.vue.model.PostDto;
import com.ssafy.vue.model.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PostDto> seePost(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> seePost(String lat, String lng) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).seePost(lat, lng);
	}

	@Override
	public List<PostDto> seeFeed(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).seeFeed(user_id);
	}

	@Override
	public List<PostDto> seePostTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).seePostTitle(title);
	}

	@Override
	public List<PostDto> userPostList(String user_id) throws SQLException {
		return sqlSession.getMapper(PostMapper.class).seeUserPost(user_id);
	}

	@Override
	public boolean registPost(PostCaptionDto postCaptionDto) throws SQLException {
		return sqlSession.getMapper(PostMapper.class).registPost(postCaptionDto);
	}
}
