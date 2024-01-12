package com.example.board.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResResult {
	
	@Schema(description = "요청 성공 여부  false : 실패 true :성공")
	public boolean success;
	
	@Schema(description = "응답 관련 메시지")
	public String message;
	
	@Schema(description = "응답에 필요한 정보" )
	public Object object;
}
