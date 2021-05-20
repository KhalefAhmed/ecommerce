package com.example.ecommerce.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ErrorController extends ExceptionInInitializerError{

    private static final String DEFAULT_VALIDATION_FAILED_MESSAGE = "Validation failed.";

    @ExceptionHandler(PasswordValidationException.class)
    public final ResponseEntity<Object> handlePasswordValidationException(PasswordValidationException ex, WebRequest request) {
        logger.error(LogMF.format("handlePasswordValidationException", ex.getLocalizedMessage(), ex));
        return handleExceptionMessageOnly(ex, request);
    }

    @ExceptionHandler(UsernameExistsException.class)
    public final ResponseEntity<Object> handleUsernameExistsException(UsernameExistsException ex, WebRequest request) {
        logger.error(LogMF.format("handleUsernameExistsException", ex.getLocalizedMessage(), ex));
        return handleExceptionMessageOnly(ex, request);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        logger.error(LogMF.format("handleUsernameNotFoundException", ex.getLocalizedMessage(), ex));
        return handleExceptionMessageOnly(ex, request);
    }


}
