package com.exercise.exception.custom;

public class EntityAlreadyExistException extends RuntimeException {

    public EntityAlreadyExistException() {
        super();
    }

    public EntityAlreadyExistException(String exception) {
        super(exception);
    }

}