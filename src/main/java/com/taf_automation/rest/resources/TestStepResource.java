package com.taf_automation.rest.resources;

import java.util.List;
import org.springframework.hateoas.ResourceSupport;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.models.entities.TestStepProperties;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestStepResource extends ResourceSupport {

    private String id;
    private String title;
    private List<TestStepProperties> testStepProperties;

    public List<TestStepProperties> getTestStepProperties() {
        return testStepProperties;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }    

    public void setTestStepProperties(List<TestStepProperties> testStepProperties) {
        this.testStepProperties = testStepProperties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestStep toTestStep() {
        TestStep testStep = new TestStep();
        testStep.setTestStepId(id);
        testStep.setTitle(title);
        testStep.setTestStepProperties(testStepProperties);
        return testStep;
    }
}
