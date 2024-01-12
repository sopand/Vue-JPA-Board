package com.example.board.req.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqBoardInsert {
	
	@Schema(description = "작성자의 시퀀스",hidden = true)
	private Long userSid;
	
	@Schema(description = "게시글의 제목")
	private String title;
	
	@Schema(description = "게시글의 내용")
	private String contents;
	
	
	
	
	
}
