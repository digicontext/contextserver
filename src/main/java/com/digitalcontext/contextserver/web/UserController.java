package com.digitalcontext.contextserver.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcontext.contextserver.model.User;
import com.digitalcontext.contextserver.service.UserService;
import com.digitalcontext.contextserver.web.response.ContextServerResponse;
import com.digitalcontext.contextserver.web.response.ResponseStatus;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(ContextController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, headers="Accept=application/json")
	public Object getUser(@RequestParam String id) {
		
		try {
			User user = userService.getUser(id);
			if (user != null) {
				return user;			
			} else {
				logger.info("User doesnot exist");
				return getResponse(ResponseStatus.FAILURE, "Could not find user");
			}
		} catch (Exception excp) {
			logger.error("Unable to get User", excp);
			return getResponse(ResponseStatus.FAILURE
					, "Could not find user : " + excp.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)	
	public ContextServerResponse saveContext(@RequestBody User user) {
		try {
			User savedUser = userService.saveUser(user);
			if(savedUser != null) {
				return getResponse(ResponseStatus.SUCCESS, user.toString());
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
	public ContextServerResponse updateContext(@RequestBody User user) {	
		try {
			User updatedContext = userService.updateUser(user);
			if(updatedContext != null) {
				return getResponse(ResponseStatus.SUCCESS, user.toString());
			} else {
				return getResponse(ResponseStatus.FAILURE, "Could not update context");
			}			
		} catch (Exception excp) {
			return new ContextServerResponse(ResponseStatus.FAILURE
					, "Could not update context : " + excp.getMessage());
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET, headers="Accept=application/json")
	public ContextServerResponse deleteContext(@RequestParam String id) {
		
		try {
			if(userService.deleteUser(id)) {
				return getResponse(ResponseStatus.SUCCESS, "User deleted");
			} else {
				return getResponse(ResponseStatus.FAILURE, "Could not delete user");
			}			
		} catch (Exception excp) {
			return new ContextServerResponse(ResponseStatus.FAILURE
					, "Could not delete user : " + excp.getMessage());
		}		
		
	}
	
	private ContextServerResponse getResponse(ResponseStatus status, String message) {
		return new ContextServerResponse(status, message);
	}
	
	
}
