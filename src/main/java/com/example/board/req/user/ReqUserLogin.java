package com.example.board.req.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqUserLogin {
	
	@Schema(description = "유저의 아이디")
	private String id;
	@Schema(description = "유저의 비밀번호")
	private String password;
}
