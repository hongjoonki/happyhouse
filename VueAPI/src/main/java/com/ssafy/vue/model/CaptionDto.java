package com.ssafy.vue.model;

public class CaptionDto {
	private String hashtag;
	private int post_no;
	
	
	public CaptionDto() {
		super();
	}

	public CaptionDto(String hashtag, int post_no) {
		super();
		this.hashtag = hashtag;
		this.post_no = post_no;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	
}
