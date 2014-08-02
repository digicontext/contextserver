package com.digitalcontext.contextserver.dao;

import java.util.List;

import com.digitalcontext.contextserver.model.ContextAccess;

public interface ContextAccessDao extends GenericDao<ContextAccess> {
	
	public List<ContextAccess> getAccessForContext(String contextId);

}
