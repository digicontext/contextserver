package com.digitalcontext.contextserver.service;

import com.digitalcontext.contextserver.model.User;

public interface UserService {

	public User getUser(String userId);	
	public User saveUser(User user);
	public boolean deleteUser(String userId);
	public User updateUser(User user);

}
