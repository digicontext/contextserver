package com.digitalcontext.contextserver.service;

import com.digitalcontext.contextserver.model.Context;

public interface ContextService {
	
	public Context getContext(String contextId);
	
	public Context saveContext(Context contextDetails);
	
	public Context updateContext(Context contextDetails);
	
	public boolean deleteContext(String contextId);

}
