package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.entity.Board;
import com.example.board.entity.User;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.UserRepository;
import com.example.board.req.board.ReqBoardInsert;
import com.example.board.res.ResResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepo;
	private final UserRepository userRepo;
	
	public ResResult boardInsert(ReqBoardInsert reqData) {
		User getUser=userRepo.findById(reqData.getUserSid()).orElse(null);
		
		if(getUser==null) {
			return ResResult.builder().message("게시글 작성자 정보가 없습니다.").success(false).build();
		}
		Board board=Board.builder()
				.title(reqData.getTitle())
				.contents(reqData.getContents())
				.user(getUser)
				.build();
		boardRepo.save(board);
		
		return ResResult.builder().message("게시글 등록 성공").success(true).build();
	}

}
