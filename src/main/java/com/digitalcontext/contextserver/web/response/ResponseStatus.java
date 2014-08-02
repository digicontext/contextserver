package com.digitalcontext.contextserver.web.response;

public enum ResponseStatus {
	
	SUCCESS(0, "Success"),
	FAILURE(1, "Failure");
	private ResponseStatus(int code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}
	
	private int code;
	private String description;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
