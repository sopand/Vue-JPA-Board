package com.example.board.req.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqBoardRemove {
	
	@Schema(description = "삭제하려는 게시글의 시퀀스")
	private Long boardSid;
	
	@Schema(description = "삭제를 시도하는 사용자의 시퀀스",hidden = true)
	private Long userSid;
}
