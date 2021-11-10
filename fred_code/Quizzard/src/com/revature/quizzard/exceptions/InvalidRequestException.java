package com.revature.quizzard.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String msg) {
        super(msg);
    }
}
