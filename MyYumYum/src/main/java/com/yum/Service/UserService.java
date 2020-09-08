package com.yum.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.Model.User;
import com.yum.Repository.UserRepository;


@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User getUser(int userId) {
		return userRepository.getOne(userId);
	}

}
