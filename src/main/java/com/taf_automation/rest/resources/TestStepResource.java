package com.taf_automation.rest.resources;

import java.util.List;
import org.springframework.hateoas.ResourceSupport;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.models.entities.TestStepProperties;

/**
 * Created by Rajesh on 11/3/17
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
        testStep.setTestStepProperties(testProperties);
        return testStep;
    }
}
