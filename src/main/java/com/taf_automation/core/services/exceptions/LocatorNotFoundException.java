package com.taf_automation.core.services.exceptions;

/**
 *
 * @author Rajesh
 */
public class LocatorNotFoundException extends RuntimeException {

    public LocatorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocatorNotFoundException(String message) {
        super(message);
    }

    public LocatorNotFoundException() {
    }
}
