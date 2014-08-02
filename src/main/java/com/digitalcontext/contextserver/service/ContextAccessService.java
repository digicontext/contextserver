package com.digitalcontext.contextserver.service;

import java.util.List;

import com.digitalcontext.contextserver.model.ContextAccess;

public interface ContextAccessService {
	
	public List<ContextAccess> getContextAccessesforContext(String contextId);
	
	public ContextAccess saveContextAccess(ContextAccess contextAccessDetails);
	
	public ContextAccess updateContextAccess(ContextAccess contextAccessDetails);
	
}
