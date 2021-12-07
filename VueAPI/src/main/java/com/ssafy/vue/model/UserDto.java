package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MemberDto : 회원정보", description = "회원의 상세 정보를 나타낸다.")
public class UserDto {

	private String user_id;
	private String user_password;
	private String user_name;
	private String user_phone;
	private String user_intro;
	private String user_picture_url;
	public UserDto() {
		super();
	}
	public UserDto(String user_id, String user_password, String user_name, String user_phone, String user_intro,
			String user_picture_url) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_intro = user_intro;
		this.user_picture_url = user_picture_url;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_intro() {
		return user_intro;
	}
	public void setUser_intro(String user_intro) {
		this.user_intro = user_intro;
	}
	public String getUser_picture_url() {
		return user_picture_url;
	}
	public void setUser_picture_url(String user_picture_url) {
		this.user_picture_url = user_picture_url;
	}
	@Override
	public String toString() {
		return "MemberDto [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", user_intro=" + user_intro + ", user_picture_url=" + user_picture_url
				+ "]";
	}

}
