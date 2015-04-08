package com.digitalcontext.contextserver.dao;

import com.digitalcontext.contextserver.model.User;

public interface UserDao extends GenericDao<User> {
	
	public User getUserFromId(String userId);

}
