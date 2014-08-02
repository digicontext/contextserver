package com.digitalcontext.contextserver.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.digitalcontext.contextserver.dao.ContextAccessDao;
import com.digitalcontext.contextserver.model.ContextAccess;

public class ContextAccessDaoImpl extends GenericDaoImpl<ContextAccess> implements ContextAccessDao {

	public List<ContextAccess> getAccessForContext(String contextId) {
		Query query = this.em
				.createQuery("select ca FROM ContextAccess ca where ca.contextId= :contextId", ContextAccess.class);
		query.setParameter("contextId", contextId);
		return query.getResultList();	
	}


}
