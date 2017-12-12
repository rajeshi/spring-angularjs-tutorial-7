package com.taf_automation.core.repositories;

import com.taf_automation.core.models.entities.TestStepDefinition;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface TestStepDefinitionRepo {

    public TestStepDefinition createStepDefinition(TestStepDefinition testStepDefinition);

    public TestStepDefinition getStepDefinitionById(String id);

    public List<TestStepDefinition> listAllStepDefinitions(int offset);

    public void updateTestStepDefinition(String id, TestStepDefinition testStepDefinition);

    public void deleteTestStepDefinition(String id);

    public TestStepDefinition getStepDefinitionByStepId(String id);
}
