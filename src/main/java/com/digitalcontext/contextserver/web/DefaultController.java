package com.digitalcontext.contextserver.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

	@RequestMapping(method=RequestMethod.GET)	
	public String getDefaultMessage() {
		return "Welcome to Context Server";
	}
}
