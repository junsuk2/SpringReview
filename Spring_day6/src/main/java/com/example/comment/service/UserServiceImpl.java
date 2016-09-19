package com.example.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.comment.dto.Comment;
import com.example.comment.dto.User;
import com.example.comment.repo.CommentRepo;
import com.example.comment.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CommentRepo comtRepo;
	
	@Override
	@Transactional
	public int join(User user) {
		int result = userRepo.addUser(user);
		//comment 공지 추가
		int i = 1/0;
		Comment comment = new Comment(0,"admin",user.getUserId()+"님이 가입했어요.");
		result = comtRepo.insert(comment);
		return result;
		
	}

}
