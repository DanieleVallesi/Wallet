package com.exercise.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String errorMessage;

    public ErrorResponse(String message, Exception e){
        timestamp = LocalDateTime.now();
        this.message = message;
        this.errorMessage = e.getLocalizedMessage();
    }

}
