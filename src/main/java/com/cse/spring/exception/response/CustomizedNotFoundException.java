package com.cse.spring.exception.response;

/**
 * 'Not Exists' Exception.
 *
 * @author julija.anna.lisaja@accenture.com
 */
public class CustomizedNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomizedNotFoundException(String message) {
        super(message);
    }
}
