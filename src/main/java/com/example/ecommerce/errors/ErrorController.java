package com.example.ecommerce.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ErrorController extends ExceptionInInitializerError{

    private static final String DEFAULT_VALIDATION_FAILED_MESSAGE = "Validation failed.";




}
