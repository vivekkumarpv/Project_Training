package com.hypereon.projectservice.exception;

public class InterviewPanelAlreadyExistException extends RuntimeException  {
    public InterviewPanelAlreadyExistException (String message){
        super(message);
    }
}
