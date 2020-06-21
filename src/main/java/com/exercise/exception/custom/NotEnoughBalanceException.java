package com.exercise.exception.custom;

public class NotEnoughBalanceException extends RuntimeException{

    public NotEnoughBalanceException() {
        super();
    }

    public NotEnoughBalanceException(String exception) {
        super(exception);
    }

}
