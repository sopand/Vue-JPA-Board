package com.example.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.model.ResultVO;
import com.example.board.res.ResUserList;
import com.example.board.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userSRV;
	
	@PostMapping(value ="/")
	public ResultVO userInsert() {
		return null;
	}
	
	@GetMapping(value ="/")
	public List<ResUserList> userList() {
		System.out.println("asdasdasd");
		List<ResUserList> list=new ArrayList<>();
		ResUserList user1= new ResUserList();
		ResUserList user2= new ResUserList();
		user1.setId("아이디");
		user1.setUser_sid(1L);
		user1.setName("이름임");
		list.add(user1);
		user2.setUser_sid(2L);
		user2.setId("dasdas");
		user2.setName("231312");
		list.add(user2);
		System.out.println(list);
		return list;
	}
	
}
