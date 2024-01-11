package com.example.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResultVO {
	
	@Schema(description = "API 요청 성공 여부")
	public Boolean success;
	
	@Schema(description = "응답 메시지")
	public String message;
}
