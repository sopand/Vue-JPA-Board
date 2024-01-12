package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.req.board.ReqBoardInsert;
import com.example.board.req.board.ReqBoardRemove;
import com.example.board.res.ResResult;
import com.example.board.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name="게시글 API",description =" 게시글 관련 API")
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardSRV;
	
	@PostMapping("/")
	@Operation(summary = "게시글 등록하기")
	@ApiResponse(responseCode = "200",description = "게시글 등록성공")
	@ApiResponse(responseCode = "400",description = "게시글 등록 실패 ")
	public ResponseEntity<ResResult> boardInsert(HttpServletRequest req,ReqBoardInsert reqData){
		HttpSession session=req.getSession(false);
		Long userSid=(Long)session.getAttribute("user_sid");
		
		if(userSid==null) {
			return ResponseEntity.status(400).body(
					ResResult.builder()
					.message("로그인이 되어있지 않습니다.")
					.build()
					);
		}
		reqData.setUserSid(userSid);
		ResResult result=boardSRV.boardInsert(reqData);
		if(result.success) {
			return ResponseEntity.status(400).body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	
	@DeleteMapping("/{boardSid}")
	@Operation(summary = "게시글 삭제하기")
	@ApiResponse(responseCode = "200",description = "게시글 삭제 성공")
	@ApiResponse(responseCode = "400",description = "게시글 삭제 실패")
	public ResponseEntity<ResResult> boardRemove(HttpServletRequest req ,ReqBoardRemove reqData){
		HttpSession session=req.getSession(false);
		Long userSid=(Long)session.getAttribute("user_sid");
		if(userSid==null) {
			return ResponseEntity.status(400).body(
					ResResult.builder()
					.message("로그인이 되어있지 않습니다.")
					.build()
					);
		}
		reqData.setUserSid(userSid);
		ResResult result=boardSRV.boardRemove(reqData);
		if(result.success) {
			return ResponseEntity.status(400).body(result);
		}
		return ResponseEntity.ok(result);
		
	}
}
