package com.slurp.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@ControllerAdvice
public class ExceptionController {

	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	public String noPageAvailable(NoSuchRequestHandlingMethodException ex) {
		return "notFound";
	}
	
	
}
