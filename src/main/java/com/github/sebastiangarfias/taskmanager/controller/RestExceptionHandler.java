package com.github.sebastiangarfias.taskmanager.controller;

import com.github.sebastiangarfias.taskmanager.service.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTaskNotFound(TaskNotFoundException ex) {
        return ex.getMessage();
    }
}
