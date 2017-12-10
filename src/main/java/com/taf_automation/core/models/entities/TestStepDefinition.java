package com.taf_automation.core.models.entities;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rajesh
 */
@Document(collection = "testStepDefinitions")
public class TestStepDefinition implements Serializable{
    @Id
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
}
