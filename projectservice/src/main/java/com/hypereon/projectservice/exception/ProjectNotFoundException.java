package com.hypereon.projectservice.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message){
        super(message);
    }
}
