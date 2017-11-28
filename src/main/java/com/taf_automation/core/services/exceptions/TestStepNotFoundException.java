package com.taf_automation.core.services.exceptions;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestStepNotFoundException extends RuntimeException {
    public TestStepNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestStepNotFoundException(String message) {
        super(message);
    }

    public TestStepNotFoundException() {
    }
}
