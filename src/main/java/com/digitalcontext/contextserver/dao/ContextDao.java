package com.digitalcontext.contextserver.dao;

import com.digitalcontext.contextserver.model.Context;

public interface ContextDao extends GenericDao<Context>{
	
	public Context getContextFromId(String contextId);

}
