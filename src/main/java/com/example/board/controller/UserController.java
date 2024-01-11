package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.req.ReqUserInsert;
import com.example.board.req.ReqUserLogin;
import com.example.board.res.ResResult;
import com.example.board.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@Tag(name = "유저 API ", description = "유저 정보에 관련된 API 입니다")
@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userSRV;

	@PostMapping(value = "/")
	@Operation(summary = "유저 회원가입")
	@ApiResponse(responseCode = "200", description = "회원가입 성공", useReturnTypeSchema = true)
	public ResponseEntity<Long> userInsert(ReqUserInsert reqData) {
		Long userSid = userSRV.userInsert(reqData);
		return ResponseEntity.ok(userSid);
	}

	@GetMapping("/login")
	@Operation(summary = "유저 로그인")
	@ApiResponse(responseCode = "200", description = "유저 로그인 성공")
	@ApiResponse(responseCode = "400", description = "유저 로그인 실패")
	public ResponseEntity<ResResult> userLogin(ReqUserLogin reqData,HttpServletRequest req) {
		HttpSession session=req.getSession(true);
		ResResult result = userSRV.userLogin(reqData);
		if (result.success) {
			return ResponseEntity.ok(result);
		}
		session.setAttribute("user_sid", result.getObject());
		return ResponseEntity.status(400).body(result);

	}

}
