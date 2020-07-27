package com.ad3bay0.gatest.exeptions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends  ResponseEntityExceptionHandler{

    @ExceptionHandler(value = Exception.class )
    public ResponseEntity<Object> handleLeakedExeptions(Exception ex){
        ApiError apiError =  new ApiError(
            HttpStatus.INTERNAL_SERVER_ERROR, 
            ex.getMessage(),
            "an error occured, try again later");

        return new ResponseEntity<>(apiError,apiError.getStatus());

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                
                List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
                String error = fieldErrors
                                   .stream()
                                   .map(fieldError -> fieldError.getField()+" : "+fieldError.getDefaultMessage())
                                   .collect(Collectors.joining());

                ApiError apiError =  new ApiError(
                                    HttpStatus.BAD_REQUEST, "Fields validation required", error);
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }

    
}