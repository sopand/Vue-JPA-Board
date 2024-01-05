package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.entity.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepo;
	
	public Long userInsert() {
		
		
		return null;
	}
}
