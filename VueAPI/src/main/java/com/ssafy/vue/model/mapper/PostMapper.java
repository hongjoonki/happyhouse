package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.CaptionDto;
import com.ssafy.vue.model.PostCaptionDto;
import com.ssafy.vue.model.PostDto;

@Mapper
public interface PostMapper {
	public List<PostDto> seePost(String user_id) throws SQLException;
	public List<PostDto> seePost(String lat, String lng) throws SQLException;
	public List<PostDto> seeFeed(String user_id) throws SQLException;
	public List<PostDto> seePostTitle(String title) throws SQLException;
	public List<PostDto> seeUserPost(String user_id) throws SQLException;
	public boolean registPost(PostCaptionDto postCaptionDto) throws SQLException;
}
