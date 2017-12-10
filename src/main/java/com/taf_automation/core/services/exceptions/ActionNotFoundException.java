package com.taf_automation.core.services.exceptions;

/**
 *
 * @author Rajesh
 */
public class ActionNotFoundException extends RuntimeException {

    public ActionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionNotFoundException(String message) {
        super(message);
    }

    public ActionNotFoundException() {
    }
}
