package com.ssafy.vue.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.vue.model.CaptionDto;
import com.ssafy.vue.model.PostCaptionDto;
import com.ssafy.vue.model.PostDto;

public interface PostService {
	public List<PostDto> seePost(String user_id) throws Exception;
	public List<PostDto> seePost(String lat, String lng) throws Exception;
	public List<PostDto> seeFeed(String user_id) throws Exception;
	public List<PostDto> seePostTitle(String title) throws Exception;
	public List<PostDto> userPostList(String user_id) throws Exception;
	public boolean registPost(PostCaptionDto postCaptionDto) throws SQLException;
}
