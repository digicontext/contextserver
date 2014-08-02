package com.digitalcontext.contextserver.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcontext.contextserver.model.ContextAccess;
import com.digitalcontext.contextserver.service.ContextAccessService;
import com.digitalcontext.contextserver.web.response.ContextServerResponse;
import com.digitalcontext.contextserver.web.response.ResponseStatus;

@RestController
@RequestMapping("/contextaccess")
public class ContextAccessController {
	
	private static final Logger logger = Logger.getLogger(ContextAccessController.class);
	
	@Autowired
	ContextAccessService contextAccessService;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public Object getContext(@PathVariable String id) {
		
		try {
			List<ContextAccess> access = contextAccessService.getContextAccessesforContext(id);
			if (access != null && access.size() > 0) {
				return access;			
			} else {
				logger.info("Context access details do not exist");
				return getResponse(ResponseStatus.FAILURE, "Could not find context");
			}
		} catch (Exception excp) {
			logger.error("Unable to get context access details", excp);
			return getResponse(ResponseStatus.FAILURE
					, "Could not find context : " + excp.getMessage());
		}
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)	
	public ContextServerResponse saveContext(@RequestBody ContextAccess context) {
		try {
			ContextAccess savedContext = contextAccessService.saveContextAccess(context);
			if(savedContext != null) {
				return getResponse(ResponseStatus.SUCCESS, context.toString());
			} else {
				return getResponse(ResponseStatus.FAILURE, "Could not save context");
			}			
		} catch (Exception excp) {
			logger.error("Failed to save Context access", excp);
			return getResponse(ResponseStatus.FAILURE
					, "Could not save context access: " + excp.getMessage());
		}

	}
	
	private ContextServerResponse getResponse(ResponseStatus status, String message) {
		return new ContextServerResponse(status, message);
	}	

}
