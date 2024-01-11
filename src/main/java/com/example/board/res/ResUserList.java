package com.example.board.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResUserList {
	
	@Schema(description = "유저의 시퀀스")
	private Long user_sid;
	
	@Schema(description = "유저의 아이디")
	private String id;
	
	@Schema(description = "유저의 이름")
	private String name;
	
}
