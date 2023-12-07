package com.hypereon.projectservice.exception;

public class JobRoleNotFoundException extends RuntimeException  {
    public JobRoleNotFoundException (String message){
        super(message);
    }
}
