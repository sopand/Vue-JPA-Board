package com.example.board.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqUserInsert {
	
	@Schema(description = "사용자 아이디")
	private String id;
	
	@Schema(description = "사용자 비밀번호")
	private String password;
	
	@Schema(description = "사용자 성명")
	private String name;

}
