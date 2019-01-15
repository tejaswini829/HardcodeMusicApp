package com.stackroute.MuzixApp.exception;

import com.stackroute.MuzixApp.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TrackAlreadyExistsException.class})
    public ResponseEntity<ErrorResponse> trackFound(TrackAlreadyExistsException ex) throws Exception{

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = {TrackDoesnotExistsException.class})
    public ResponseEntity<ErrorResponse> trackNotFound(TrackDoesnotExistsException ex) throws Exception{

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
}
