package com.taf_automation.core.services.exceptions;

/**
 *
 * @author Rajesh
 */
public class TestStepDefinitionNotFoundException extends RuntimeException {

    public TestStepDefinitionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestStepDefinitionNotFoundException(String message) {
        super(message);
    }

    public TestStepDefinitionNotFoundException() {
    }
}
