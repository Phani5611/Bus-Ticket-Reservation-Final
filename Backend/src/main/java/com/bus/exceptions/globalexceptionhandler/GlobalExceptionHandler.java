package com.bus.exceptions.globalexceptionhandler;

import com.bus.exceptions.BadRequestException;
import com.bus.exceptions.DuplicateResourceException;
import com.bus.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex , WebRequest request){
        ErrorResponse error = new ErrorResponse("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(),request.getDescription(false), LocalDateTime.now());
        return  ResponseEntity.ok(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse("RESOURCE_NOT_FOUND",HttpStatus.NOT_FOUND.value(),ex.getMessage(),request.getDescription(false),LocalDateTime.now());
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateResource(DuplicateResourceException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse("DUPLICATE_RESOURCE_EXCEPTION",HttpStatus.CONFLICT.value(),ex.getMessage(),request.getDescription(false),LocalDateTime.now());
        return  ResponseEntity.ok(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse("BAD_REQUEST",HttpStatus.BAD_REQUEST.value(),ex.getMessage(),request.getDescription(false),LocalDateTime.now());
        return  ResponseEntity.ok(error);
    }

}
