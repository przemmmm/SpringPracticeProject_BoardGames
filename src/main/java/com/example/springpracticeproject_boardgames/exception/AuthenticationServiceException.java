package com.example.springpracticeproject_boardgames.exception;

public class AuthenticationServiceException extends RuntimeException{

    public AuthenticationServiceException (String message){
        super(message);
    }
}
