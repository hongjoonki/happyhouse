package com.ssafy.vue.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.CaptionDto;
import com.ssafy.vue.model.PostCaptionDto;
import com.ssafy.vue.model.PostDto;
import com.ssafy.vue.model.UserDto;
import com.ssafy.vue.model.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/posts")
@Api("게시글 컨트롤러  API V1")
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private PostService postService;
	
	@ApiOperation(value = "위치설정 게시글 목록", notes = "lat, lng 범위에 맞는 정보를 반환한다.", response = List.class)
	@GetMapping("/location")
	public ResponseEntity<List<PostDto>> seePost(@ApiParam(value = "post를 얻기위한 위도, 경도 정보", required = true) PostDto postDto) throws Exception {
		logger.info("seePost - 호출");
		return new ResponseEntity<List<PostDto>>(postService.seePost(postDto.getLat(), postDto.getLng()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "피드 목록", notes = "follow한 사용자의 게시글을 반환한다.", response = List.class)
	@GetMapping("/feed")
	public ResponseEntity<List<PostDto>> seeFeed(@ApiParam(value = "사용자 아이디", required = true) PostDto postDto) throws Exception {
		logger.info("seeFeed - 호출");
		return new ResponseEntity<List<PostDto>>(postService.seeFeed(postDto.getUser_id()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "위치설정 게시글 목록", notes = "lat, lng 범위에 맞는 정보를 반환한다.", response = List.class)
	@GetMapping("/title/{title}")
	public ResponseEntity<List<PostDto>> seePostTitle(@ApiParam(value = "post를 얻기위한 타이틀 정보", required = true) PostDto postDto) throws Exception {
		logger.info("seePost - 호출"+postDto.getTitle());
		return new ResponseEntity<List<PostDto>>(postService.seePostTitle(postDto.getTitle()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 아이디로 포스트 검색", notes = "입력 값과 일치하는 포스트 정보를 담은 List를 반환", response = List.class)
	@GetMapping("/user/{user_id}")
	public ResponseEntity<List<PostDto>> seeUserPost(
			@PathVariable("user_id") @ApiParam(value = "회원 아이디.", required = true) String user_id,
			HttpServletRequest request) throws Exception {
		logger.info("userList - 호출");
		return new ResponseEntity<List<PostDto>>(postService.userPostList(user_id), HttpStatus.OK);
	}
	
	@ApiOperation(value="post 등록", notes = "post 등록", response = String.class)
	@PostMapping
	public ResponseEntity<String> registPost(@RequestBody @ApiParam(value="글 정보.") PostCaptionDto postCaptionDto) throws Exception {
		System.out.println(postCaptionDto);
//		System.out.println(captionList);
//		PostCaptionDto postCaptionDto = new PostCaptionDto();
//		postCaptionDto.setPost_no(postDto.getPost_no());
//		postCaptionDto.setTitle(postDto.getTitle());
//		postCaptionDto.setContent(postDto.getContent());
//		postCaptionDto.setPicture_url(postDto.getPicture_url());
//		postCaptionDto.setUser_id(postDto.getUser_id());
//		postCaptionDto.setGrade(postDto.getGrade());
//		postCaptionDto.setLat(postDto.getLat());
//		postCaptionDto.setLng(postDto.getLng());
//		postCaptionDto.setLike(postDto.getLike());
//		postCaptionDto.setRegtime(postDto.getRegtime());
		//postCaptionDto.setList(captionList);
		if (postService.registPost(postCaptionDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
