package com.geenie.renting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geenie.renting.beans.User;
import com.geenie.renting.exceptions.NoUserFoundException;
import com.geenie.renting.repository.UserRepository;
import com.geenie.renting.service.interfaces.IUserMYSQLService;

@Service
public class UserMySQLServiceImpl implements IUserMYSQLService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserMySQLServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void addUser(User user) {
		LOGGER.info("adding user {}", user);
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		LOGGER.info("retriving all users");
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<String> getUsersFullName() {
		List<String> usersFullName = new ArrayList<>();
		for (User user : getAllUsers()) {
			usersFullName.add(user.getFirstName() + " " + user.getLastName());
		}
		return usersFullName;
	}

	@Override
	public User getUserByFullName(String fullName) throws NoUserFoundException {
		String tmp = "";
		for (User user : getAllUsers()) {
			tmp = user.getFirstName() + " " + user.getLastName();
			if (fullName.equals(tmp)) {
				return user;
			}
		}
		throw new NoUserFoundException("no user found with name " + fullName);
	}

}
