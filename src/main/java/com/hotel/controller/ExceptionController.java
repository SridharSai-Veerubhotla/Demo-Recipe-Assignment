package com.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.exception.RecipeException;
import com.hotel.exception.UserException;
import com.hotel.pojo.ErrorResponse;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<Object> userException(UserException exception) {
		ErrorResponse response = new ErrorResponse("FAIL", exception.getLocalizedMessage());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@ExceptionHandler(value = RecipeException.class)
	public ResponseEntity<Object> recipeException(RecipeException exception) {
		ErrorResponse response = new ErrorResponse("FAIL", exception.getLocalizedMessage());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
