package com.cse.spring.exception;

import com.cse.spring.exception.response.CustomisedValidationException;
import com.cse.spring.exception.response.CustomizedNotFoundException;
import com.cse.spring.model.CustomizedExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

/**
 * Customized Exception handler class, handle exception parts.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(value = CustomizedNotFoundException.class)
    public ResponseEntity<Object> customizedNotFoundExceptionHandler(CustomizedNotFoundException e) {
        return new ResponseEntity<>(requestType(e, "404", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CustomisedValidationException.class)
    public ResponseEntity<Object> customisedValidationExceptionError(CustomizedNotFoundException e) {
        return new ResponseEntity<>(requestType(e, "400", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    private CustomizedExceptionModel requestType(Exception e, String errorCode, HttpStatus httpStatus) {
        return new CustomizedExceptionModel(
                e.getMessage(),
                errorCode,
                httpStatus,
                ZonedDateTime.now());
    }

    /**
     * Custom message for all exceptions.
     *
     * @param entityName entity name where exception has been caused.
     * @param recordName field name, where exception caused.
     * @param recordValue value of the field.
     * @return custom exception message.
     */
    public static String customExceptionMessage(String entityName, String recordName, String recordValue) {
        return "No " + entityName + " was found with " + recordName + " : " + recordValue;
    }
}
