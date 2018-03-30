package com.geenie.renting.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.geenie.renting.beans.User;
import com.geenie.renting.exceptions.NoUserFoundException;

public interface IUserMYSQLService {

	@Transactional
	public void addUser(User user);

	public List<User> getAllUsers();

	public List<String> getUsersFullName();

	public User getUserByFullName(String fullName) throws NoUserFoundException;

}
