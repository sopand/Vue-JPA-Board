package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.req.ReqUserInsert;
import com.example.board.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@Tag(name =  "유저 API " , description = "유저 정보에 관련된 API 입니다")
@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userSRV;
	
	@PostMapping(value ="/")
	@Operation(summary = "유저 회원가입")
	@ApiResponse(responseCode = "200", description = "회원가입 성공", useReturnTypeSchema = true)
	public ResponseEntity<Long> userInsert(ReqUserInsert reqData) {
		Long userSid=userSRV.userInsert(reqData);
		return ResponseEntity.ok(userSid);
	}
	
	
}
