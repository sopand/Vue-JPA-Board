package com.example.board.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.board.entity.User;
import com.example.board.repository.UserRepository;
import com.example.board.req.ReqUserInsert;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepo;
	private final PasswordEncoder encoder;
	
	public Long userInsert(ReqUserInsert reqData) {
		User data= User.builder()
				.id(reqData.getId())
				.password(encoder.encode(reqData.getPassword()))
				.name(reqData.getName())
				.build();
		
		return userRepo.save(data).getUserSid();
	}
}
