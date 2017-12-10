package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.TestStepDefinition;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class TestStepDefinitionResource extends ResourceSupport {
    
    private String testStepDefinitionId;
    private String testStepId;
    private List<String> actions;
    
    public String getTestStepDefinitionId() {
        return testStepDefinitionId;
    }
    
    public void setTestStepDefinitionId(String testStepDefinitionId) {
        this.testStepDefinitionId = testStepDefinitionId;
    }
    
    public String getTestStepId() {
        return testStepId;
    }
    
    public void setTestStepId(String testStepId) {
        this.testStepId = testStepId;
    }
    
    public List<String> getActions() {
        return actions;
    }
    
    public void setActions(List<String> actions) {
        this.actions = actions;
    }
    
    public TestStepDefinition toTestStepDefinition() {
        TestStepDefinition testStepDefinition = new TestStepDefinition();
        testStepDefinition.setTestStepId(testStepId);
        testStepDefinition.setTestStepDefinitionId(testStepDefinitionId);
        testStepDefinition.setActions(actions);
        return testStepDefinition;
    }
}
