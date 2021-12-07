package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LikeDto : 게시글 좋아요 정보", description = "게시글에 대한 좋아요 정보 저장 데이터.")
public class LikeDto {
	@ApiModelProperty(value = "회원 아이디")
	private String user_id;
	@ApiModelProperty(value = "게시글 고유번호")
	private String post_no;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
}
