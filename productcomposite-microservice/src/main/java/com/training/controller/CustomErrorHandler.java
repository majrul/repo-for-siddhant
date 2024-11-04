package com.training.controller;

import feign.RetryableException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<Status> handleRetryableException(RetryableException ex) {
        Status status = new Status();
        status.setStatus(false);
        status.setMessageIfAny("Service down, try after sometime!");

        return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
    }

    @Getter@Setter
    public static class Status {
        private boolean status;
        private String messageIfAny;
    }
}
