package com.hypereon.projectservice.exception;

public class InterviewPanelNotFoundException extends RuntimeException  {
    public InterviewPanelNotFoundException (String message){
        super(message);
    }
}