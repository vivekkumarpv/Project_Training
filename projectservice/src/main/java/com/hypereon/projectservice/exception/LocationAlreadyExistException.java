package com.hypereon.projectservice.exception;

public class LocationAlreadyExistException extends RuntimeException  {
    public LocationAlreadyExistException (String message){
        super(message);
    }
}
