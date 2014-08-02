package com.digitalcontext.contextserver.web.response;

public class ContextServerResponse {
	
	private String status;
	private String message;
	
	public ContextServerResponse(ResponseStatus status, String message) {
		super();
		this.status = status.getDescription();
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status.getDescription();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
