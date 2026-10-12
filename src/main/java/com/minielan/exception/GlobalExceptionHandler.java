package com.minielan.exception;

import com.minielan.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AdvertisementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAdvertisementNotFoundException(AdvertisementNotFoundException exception,
                                                                          HttpServletRequest request){
        return buildResponse(HttpStatus.NOT_FOUND,exception.getMessage(),request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                                                   HttpServletRequest request){
        String message = String.format("Invalid value '%s' for parameter '%s'",
                exception.getValue(), exception.getName());
        return buildResponse(HttpStatus.BAD_REQUEST,message,request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception,
                                                         HttpServletRequest request){
        log.error("Unexpected error at {}", request.getRequestURI(), exception);
        String message = "An unexpected error occurred. Please try again later.";
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,message,request);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(HttpServletRequest request){
        String message = String.format("Endpoint '%s' not found", request.getRequestURI());
        return buildResponse(HttpStatus.NOT_FOUND,message,request);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,
                                                                                      HttpServletRequest request){
        String message = String.format("Method '%s' is not supported for this endpoint",
                exception.getMethod());
        return buildResponse(HttpStatus.METHOD_NOT_ALLOWED,message,request);
    }
    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status,
                                                        String message,
                                                        HttpServletRequest request){
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getRequestURI());

        return ResponseEntity.status(status).body(response);
    }

}
