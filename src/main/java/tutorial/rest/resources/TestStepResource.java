package tutorial.rest.resources;

import java.util.List;
import org.springframework.hateoas.ResourceSupport;
import tutorial.core.models.entities.TestStep;
import tutorial.core.models.entities.TestStepProperties;

/**
 * Created by Chris on 6/30/14.
 */
public class TestStepResource extends ResourceSupport {

    private String title;
    private List<TestStepProperties> testProperties;

    public List<TestStepProperties> getTestProperties() {
        return testProperties;
    }

    public void setTestProperties(List<TestStepProperties> testProperties) {
        this.testProperties = testProperties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestStep toTestStep() {
        TestStep testStep = new TestStep();
        testStep.setTitle(title);
        testStep.setTestScriptProperties(testProperties);
        return testStep;
    }
}
