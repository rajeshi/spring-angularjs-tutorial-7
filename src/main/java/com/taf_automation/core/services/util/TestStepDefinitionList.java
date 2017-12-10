package com.taf_automation.core.services.util;

import com.taf_automation.core.models.entities.TestStepDefinition;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public class TestStepDefinitionList {

    private List<TestStepDefinition> testStepDefinitions;

    public TestStepDefinitionList(List<TestStepDefinition> testStepDefinitions) {
        this.testStepDefinitions = testStepDefinitions;
    }

    public List<TestStepDefinition> getTestStepDefinitions() {
        return testStepDefinitions;
    }

    public void setTestStepDefinitions(List<TestStepDefinition> testStepDefinitions) {
        this.testStepDefinitions = testStepDefinitions;
    }   
}
