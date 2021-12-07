package com.ssafy.vue.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class PostCaptionDto {
	@ApiModelProperty(value = "글번호")
	private int post_no;
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "사진 폴더 경로")
	private String picture_url;
	@ApiModelProperty(value = "게시글 user 사진 폴더 경로")
	private String user_picture_url;
	@ApiModelProperty(value = "작성자 ID")
	private String user_id;
	@ApiModelProperty(value = "조회수")
	private int grade;
	@ApiModelProperty(value = "lat")
	private String lat;
	@ApiModelProperty(value = "lng")
	private String lng;
	@ApiModelProperty(value = "좋아요")
	private int like;
	@ApiModelProperty(value = "게시 날짜, 시간")
	private String regtime;
	List<String> list;
	public PostCaptionDto() {
		super();
	}
	public PostCaptionDto(int post_no, String title, String content, String picture_url, String user_picture_url,
			String user_id, int grade, String lat, String lng, int like, String regtime, List<String> list) {
		super();
		this.post_no = post_no;
		this.title = title;
		this.content = content;
		this.picture_url = picture_url;
		this.user_picture_url = user_picture_url;
		this.user_id = user_id;
		this.grade = grade;
		this.lat = lat;
		this.lng = lng;
		this.like = like;
		this.regtime = regtime;
		this.list = list;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public String getUser_picture_url() {
		return user_picture_url;
	}
	public void setUser_picture_url(String user_picture_url) {
		this.user_picture_url = user_picture_url;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PostCaptionDto [post_no=" + post_no + ", title=" + title + ", content=" + content + ", picture_url="
				+ picture_url + ", user_picture_url=" + user_picture_url + ", user_id=" + user_id + ", grade=" + grade
				+ ", lat=" + lat + ", lng=" + lng + ", like=" + like + ", regtime=" + regtime + ", list=" + list + "]";
	}

	
	
	
}
