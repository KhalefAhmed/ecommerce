package com.example.ecommerce.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class ErrorController extends ExceptionInInitializerError{

    public final ResponseEntity<Object> handlePasswordValidationException(PasswordValidationException ex, WebRequest request) {
        logger.error(LogMF.format("handlePasswordValidationException", ex.getLocalizedMessage(), ex));
        return handleExceptionMessageOnly(ex, request);
    }

    public final ResponseEntity<Object> handleUsernameExistsException(UsernameExistsException ex, WebRequest request) {
        logger.error(LogMF.format("handleUsernameExistsException", ex.getLocalizedMessage(), ex));
        return handleExceptionMessageOnly(ex, request);
    }
}
