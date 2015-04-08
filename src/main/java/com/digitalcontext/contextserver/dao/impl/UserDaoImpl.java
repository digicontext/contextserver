package com.digitalcontext.contextserver.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.digitalcontext.contextserver.dao.UserDao;
import com.digitalcontext.contextserver.model.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public User getUserFromId(String userId) {
		Query query = this.em
				.createQuery("select u FROM User u where u.userId= :userId", User.class);
		query.setParameter("userId", userId);
		List<User> contexts = query.getResultList();
		if (contexts != null && contexts.size() == 1) {
			return contexts.get(0);
		}
		return null;	
		
	}
}
