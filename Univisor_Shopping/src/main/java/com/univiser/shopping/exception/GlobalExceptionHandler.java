package com.univiser.shopping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The Class GlobalExceptionHandler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * Handle resource not found exception.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	//Handle specific exceptions
			@ExceptionHandler(ResourceNotFoundException.class)
			public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException
					exception, WebRequest request){
				ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
				
			}

}
