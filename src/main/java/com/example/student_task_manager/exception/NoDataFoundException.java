package com.example.student_task_manager.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class NoDataFoundException extends Exception{

    public NoDataFoundException(String message) {
        super(message);
    }
}
