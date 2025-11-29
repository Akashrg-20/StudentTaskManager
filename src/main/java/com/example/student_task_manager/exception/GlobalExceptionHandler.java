package com.example.student_task_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoDataFoundException.class)
    public String handleNoDataFoundEx(NoDataFoundException ex, Model model){
        List<String> errorMessages=List.of(ex.getMessage(),
                String.valueOf(LocalDateTime.now()),"There was an unexpected error :"+ HttpStatus.NO_CONTENT+", status=204");
        model.addAttribute("errorMessage",errorMessages);
        return "error-page";
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String handleEx(Exception ex, Model model){
        List<String> errorMessages=List.of(ex.getMessage(),
                String.valueOf(LocalDateTime.now()),"There was an unexpected error :"+ HttpStatus.NO_CONTENT+", status=204");
        model.addAttribute("errorMessage",errorMessages);
        return "error-page";
    }

}
