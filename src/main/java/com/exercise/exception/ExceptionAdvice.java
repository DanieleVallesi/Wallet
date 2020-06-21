package com.exercise.exception;

import com.exercise.exception.custom.EntityAlreadyExistException;
import com.exercise.exception.custom.EntityDoesntExistException;
import com.exercise.exception.custom.NotEnoughBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> userAlreadyExistException(Exception e) {
        ErrorResponse error = new ErrorResponse("Internal Server Error", e);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityDoesntExistException.class)
    public final ResponseEntity<ErrorResponse> userAlreadyExistException(EntityDoesntExistException e) {
        ErrorResponse error = new ErrorResponse("Entity Doesn't Exist", e);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public final ResponseEntity<ErrorResponse> userAlreadyExistException(EntityAlreadyExistException e) {
        ErrorResponse error = new ErrorResponse("Entity Already Exist", e);
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotEnoughBalanceException.class)
    public final ResponseEntity<ErrorResponse> userAlreadyExistException(NotEnoughBalanceException e) {
        ErrorResponse error = new ErrorResponse("Not Enough Balance", e);
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

}
