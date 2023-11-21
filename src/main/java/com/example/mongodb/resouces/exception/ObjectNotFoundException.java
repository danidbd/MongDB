package com.example.mongodb.resouces.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
