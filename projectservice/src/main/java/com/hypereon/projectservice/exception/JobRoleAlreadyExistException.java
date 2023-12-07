package com.hypereon.projectservice.exception;

public class JobRoleAlreadyExistException extends RuntimeException  {
    public JobRoleAlreadyExistException (String message){
        super(message);
    }
}
