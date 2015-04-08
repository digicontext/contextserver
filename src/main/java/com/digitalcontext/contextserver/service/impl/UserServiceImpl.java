package com.digitalcontext.contextserver.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcontext.contextserver.dao.AuthenticationTypeDao;
import com.digitalcontext.contextserver.dao.UserDao;
import com.digitalcontext.contextserver.model.AuthenticationType;
import com.digitalcontext.contextserver.model.User;
import com.digitalcontext.contextserver.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	AuthenticationTypeDao authTypeDao;
	
	@Transactional	
	public User getUser(String userId) {
		return userDao.getUserFromId(userId);
	}

	@Transactional	
	public User saveUser(User user) {
		// Enrich with details
		user.setStatus(1);
		user.setCreateTime(new Date());
		user.setAuthType(getAuthTypeFromId(2));
		
		User existingContext = userDao.getUserFromId(user.getUserId());
		if (existingContext != null) {
			throw new RuntimeException("User with Id : " + user.getUserId() + " already exists");
		} else {
			return userDao.create(user);
		}

	}

	@Transactional	
	public boolean deleteUser(String userId) {
		User user = userDao.getUserFromId(userId);
		if (user != null) {
			userDao.delete(user.getId());
			return true;
		} else {
			return false;
		}		
	}

	@Transactional	
	public User updateUser(User user) {
		
		// It should never come here !!!
		if (user.getId() != null) {
			throw new RuntimeException("User Id is passed incorrectly");		
		} else {
			User existingUser = userDao.getUserFromId(user.getUserId());
			
			// These are the data points that cannot be passed by the client
			// hence need to set them i.e the ones that are JsonIgnored
			user.setId(existingUser.getId());
			user.setCreateTime(existingUser.getCreateTime());
			user.setAuthType(existingUser.getAuthType());
			user.setStatus(existingUser.getStatus());
			user.setUpdateTime(new Date());

			return userDao.update(user);
		}
	}

	// @TODO - Cache the list later
	private AuthenticationType getAuthTypeFromId(int authTypeid) {	
		return authTypeDao.find(authTypeid);
	}
}
