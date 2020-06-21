package com.exercise.exception.custom;

public class EntityDoesntExistException extends RuntimeException {

    public EntityDoesntExistException() {
        super();
    }

    public EntityDoesntExistException(String exception) {
        super(exception);
    }

}
