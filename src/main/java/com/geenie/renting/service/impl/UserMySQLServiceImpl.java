package com.geenie.renting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geenie.renting.beans.User;
import com.geenie.renting.repository.UserRepository;
import com.geenie.renting.service.interfaces.IUserMYSQLService;

@Service
public class UserMySQLServiceImpl implements IUserMYSQLService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

}
