package com.digitalcontext.contextserver.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getStatus() {
		return "Running";
	}

}
