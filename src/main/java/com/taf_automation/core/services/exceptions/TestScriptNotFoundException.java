package com.taf_automation.core.services.exceptions;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestScriptNotFoundException extends RuntimeException {

    public TestScriptNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestScriptNotFoundException(String message) {
        super(message);
    }

    public TestScriptNotFoundException() {
    }
}
