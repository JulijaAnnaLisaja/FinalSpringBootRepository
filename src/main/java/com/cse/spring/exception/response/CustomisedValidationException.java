package com.cse.spring.exception.response;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class CustomisedValidationException extends ConstraintViolationException {

    private static final long serialVersionUID = 1L;

    public CustomisedValidationException(String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(message, constraintViolations);
    }

    public CustomisedValidationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(constraintViolations);
    }
}
