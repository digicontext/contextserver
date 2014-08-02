package com.digitalcontext.contextserver.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcontext.contextserver.dao.ContextAccessDao;
import com.digitalcontext.contextserver.model.ContextAccess;
import com.digitalcontext.contextserver.service.ContextAccessService;

public class ContextAccessServiceImpl implements ContextAccessService {

	@Autowired
	ContextAccessDao contextAccessDao;
	
	@Transactional	
	public List<ContextAccess> getContextAccessesforContext(String contextId) {
		return contextAccessDao.getAccessForContext(contextId);
	}

	@Transactional	
	public ContextAccess saveContextAccess(ContextAccess contextAccessDetails) {	
		contextAccessDetails.setAccessTime(new Date());
		return contextAccessDao.create(contextAccessDetails);
	}

	@Transactional	
	public ContextAccess updateContextAccess(ContextAccess contextAccessDetails) {
		return contextAccessDao.update(contextAccessDetails);
	}

}
