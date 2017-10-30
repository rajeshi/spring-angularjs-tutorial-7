package tutorial.core.services.exceptions;

/**
 * Created by Chris on 6/28/14.
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
