package com.github.kwesidev.restapp.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
	private String message;
	private List<String> details;
	private LocalDateTime timeStamp;

	public ErrorResponse(String message, List<String> details) {
		this.message = message;
		this.details = details;
		this.timeStamp = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
