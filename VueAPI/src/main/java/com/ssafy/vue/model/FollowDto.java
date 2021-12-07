package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FollowDto : Follow 정보", description = "회원간의 Follow 내역 정보 저장 데이터.")
public class FollowDto {
	@ApiModelProperty(value = "follow 회원 아이디")
	private String user_id;
	@ApiModelProperty(value = "user 아이디")
	private String follower_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}
	
}
