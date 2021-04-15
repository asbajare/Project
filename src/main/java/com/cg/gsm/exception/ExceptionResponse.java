package com.cg.gsm.exception;



public class ExceptionResponse {
private String message;
private String details;
public ExceptionResponse(String message, String details) {
	super();
	this.message = message;
	this.details = details;
}
public String getMessage() {
	return message;
}
public String getDetails() {
	return details;
}
public void setMessage(String message) {
	this.message = message;
}
public void setDetails(String details) {
	this.details = details;
}

}
