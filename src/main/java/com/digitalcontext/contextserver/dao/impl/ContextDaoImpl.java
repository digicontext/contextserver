package com.digitalcontext.contextserver.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.digitalcontext.contextserver.dao.ContextDao;
import com.digitalcontext.contextserver.model.Context;

public class ContextDaoImpl extends GenericDaoImpl<Context> implements ContextDao {

	public Context getContextFromId(String contextId) {
		Query query = this.em
				.createQuery("select c FROM Context c where c.contextId= :contextId", Context.class);
		query.setParameter("contextId", contextId);
		List<Context> contexts = query.getResultList();
		if (contexts != null && contexts.size() == 1) {
			return contexts.get(0);
		}
		return null;	
	}

}
