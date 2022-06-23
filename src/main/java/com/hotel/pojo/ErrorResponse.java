package com.hotel.pojo;

public class ErrorResponse {

	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMesg() {
		return errorMesg;
	}

	public void setErrorMesg(String errorMesg) {
		this.errorMesg = errorMesg;
	}



	String errorMesg;
	

	public ErrorResponse(String status, String errorMesg) {
		super();
		this.status = status;
		this.errorMesg = errorMesg;
		
	}
}
