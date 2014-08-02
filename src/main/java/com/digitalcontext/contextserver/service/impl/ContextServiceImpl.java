package com.digitalcontext.contextserver.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcontext.contextserver.dao.ContextDao;
import com.digitalcontext.contextserver.model.Context;
import com.digitalcontext.contextserver.service.ContextService;

public class ContextServiceImpl implements ContextService {

	@Autowired
	ContextDao contextDao;

	@Transactional	
	public Context getContext(String contextId) {	
		return contextDao.getContextFromId(contextId);
	}

	@Transactional
	public Context saveContext(Context context) {
		Context existingContext = contextDao.getContextFromId(context.getContextId());
		if (existingContext != null) {
			throw new RuntimeException("Context with Id : " + context.getContextId() + " already exists");
		} else {
			return contextDao.create(context);
		}
	}

	@Transactional	
	public Context updateContext(Context context) {
		context.setUpdateTime(new Date());
		if (context.getId() != null) {
			return contextDao.update(context);		
		} else {
			Context existingContext = contextDao.getContextFromId(context.getContextId());
			context.setId(existingContext.getId());
			return contextDao.update(context);
		}
	}

	@Transactional	
	public boolean deleteContext(String contextId) {
		Context context = contextDao.getContextFromId(contextId);
		if (context != null) {
			contextDao.delete(context.getId());
			return true;
		} else {
			return false;
		}
	}

}
