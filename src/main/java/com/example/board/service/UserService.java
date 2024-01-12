package com.example.board.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.board.entity.User;
import com.example.board.repository.UserRepository;
import com.example.board.req.user.ReqUserInsert;
import com.example.board.req.user.ReqUserLogin;
import com.example.board.res.ResResult;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepo;
	private final PasswordEncoder encoder;

	public Long userInsert(ReqUserInsert reqData) {
		User data = User.builder()
				.id(reqData.getId())
				.password(encoder.encode(reqData.getPassword()))
				.name(reqData.getName())
				.build();

		return userRepo.save(data).getUserSid();
	}

	public ResResult userLogin(ReqUserLogin reqData) {
		User user = userRepo.findById(reqData.getId()).orElse(null);
		if (user == null) {
			return ResResult.builder().success(false).message("해당하는 유저를 찾을 수 없습니다.").build();
		}
		
		if (!encoder.matches(reqData.getPassword(), user.getPassword())) {
			return ResResult.builder().success(false).message("비밀번호가 일치하지 않습니다.").build();
		}
		
		return ResResult.builder().success(true).message("로그인 성공").object(user.getUserSid()).build();
	}
	
	
}
