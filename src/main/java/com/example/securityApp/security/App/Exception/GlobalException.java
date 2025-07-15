package com.example.securityApp.security.App.Exception;

import com.example.securityApp.security.App.advice.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex, WebRequest req) {
        ApiError error = new ApiError(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
//        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
//        ApiError error = new ApiError(
//                errorMessage,
//                HttpStatus.BAD_REQUEST
//        );
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }

}
