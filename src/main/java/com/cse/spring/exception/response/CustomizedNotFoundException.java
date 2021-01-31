package com.cse.spring.exception.response;

import javassist.NotFoundException;

/**
 * 'Not Exists' Exception.
 *
 * @author julija.anna.lisaja@accenture.com
 */
public class CustomizedNotFoundException extends NotFoundException {

    private static final long serialVersionUID = 1L;

    public CustomizedNotFoundException(String message) {
        super(message);
    }
}
