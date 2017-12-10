package com.taf_automation.core.services.exceptions;

/**
 *
 * @author Rajesh
 */
public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException() {
    }
}
