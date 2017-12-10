package com.taf_automation.core.services;

import com.taf_automation.core.models.entities.TestStepDefinition;
import com.taf_automation.core.services.util.TestStepDefinitionList;

/**
 *
 * @author Rajesh
 */
public interface TestStepDefinitionService {

    public TestStepDefinition createStepDefinition(TestStepDefinition testStepDefinition);

    public TestStepDefinition getStepDefinitionById(String id);

    public TestStepDefinitionList listAllStepDefinitions(int offset);

    public void updateTestStepDefinition(String id, TestStepDefinition testStepDefinition);

    public void deleteTestStepDefinition(String id);
}
