package com.digitalcontext.contextserver.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcontext.contextserver.model.Context;
import com.digitalcontext.contextserver.service.ContextService;
import com.digitalcontext.contextserver.web.response.ContextServerResponse;
import com.digitalcontext.contextserver.web.response.ResponseStatus;

@RestController
@RequestMapping("/context")
public class ContextController {
	
	private static final Logger logger = Logger.getLogger(ContextController.class);
	@Autowired
	ContextService contextService;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public Object getContext(@PathVariable String id) {
		
		try {
			Context context = contextService.getContext(id);
			if (context != null) {
				return context;			
			} else {
				logger.info("Context doesnot exist");
				return getResponse(ResponseStatus.FAILURE, "Could not find context");
			}
		} catch (Exception excp) {
			logger.error("Unable to get Context", excp);
			return getResponse(ResponseStatus.FAILURE
					, "Could not find context : " + excp.getMessage());
		}
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)	
	public ContextServerResponse saveContext(@RequestBody Context context) {
		try {
			Context savedContext = contextService.saveContext(context);
			if(savedContext != null) {
				return getResponse(ResponseStatus.SUCCESS, context.toString());
			} else {
				return getResponse(ResponseStatus.FAILURE, "Could not save context");
			}			
		} catch (Exception excp) {
			logger.error("Failed to save Context", excp);
			return getResponse(ResponseStatus.FAILURE
					, "Could not save context : " + excp.getMessage());
		}

	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)	
	public ContextServerResponse updateContext(@RequestBody Context context) {	
		try {
			Context updatedContext = contextService.updateContext(context);
			if(updatedContext != null) {
				return getResponse(ResponseStatus.SUCCESS, context.toString());
			} else {
				return getResponse(ResponseStatus.FAILURE, "Could not update context");
			}			
		} catch (Exception excp) {
			return new ContextServerResponse(ResponseStatus.FAILURE
					, "Could not update context : " + excp.getMessage());
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public ContextServerResponse deleteContext(@PathVariable String id) {
		
		try {
			if(contextService.deleteContext(id)) {
				return getResponse(ResponseStatus.SUCCESS, "Context deleted");
			} else {
				return getResponse(ResponseStatus.FAILURE, "Could not delete context");
			}			
		} catch (Exception excp) {
			return new ContextServerResponse(ResponseStatus.FAILURE
					, "Could not delete context : " + excp.getMessage());
		}		
		
	}
	
	private ContextServerResponse getResponse(ResponseStatus status, String message) {
		return new ContextServerResponse(status, message);
	}

}
