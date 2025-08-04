package com.br.viniciuspadovam.planningpoker.room.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RoomAlreadyExistsException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	public RoomAlreadyExistsException() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, "One Room already exists.");
	}
	
	public RoomAlreadyExistsException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}
	
}
