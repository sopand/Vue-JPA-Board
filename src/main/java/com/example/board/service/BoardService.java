package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.entity.Board;
import com.example.board.entity.User;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.UserRepository;
import com.example.board.req.board.ReqBoardInsert;
import com.example.board.req.board.ReqBoardRemove;
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
	
	public ResResult boardRemove(ReqBoardRemove reqData) {
		Board findBoard=boardRepo.findById(reqData.getBoardSid()).orElse(null);
		if(findBoard==null) {
			return ResResult.builder()
			.success(false)
			.message("삭제할 게시글이 존재하지 않습니다.")
			.build();
		}
		if(!findBoard.getUser().getUserSid().equals(reqData.getUserSid())) {
			return ResResult.builder()
					.success(false)
					.message("해당 게시글의 작성자가 아닙니다.")
					.build();
		}
		
		boardRepo.delete(findBoard);
		
		return ResResult.builder()
				.success(true)
				.message("게시글 삭제가 완료되었습니다.")
				.build();
		
		
		
	}

}
