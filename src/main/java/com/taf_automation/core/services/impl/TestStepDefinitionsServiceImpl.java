package com.taf_automation.core.services.impl;

import com.taf_automation.core.models.entities.TestStepDefinition;
import com.taf_automation.core.repositories.TestStepDefinitionRepo;
import com.taf_automation.core.services.TestStepDefinitionService;
import com.taf_automation.core.services.util.TestStepDefinitionList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajesh
 */
@Service
public class TestStepDefinitionsServiceImpl implements TestStepDefinitionService {

    @Autowired
    private TestStepDefinitionRepo testStepDefinitionRepo;

    @Override
    public TestStepDefinition createStepDefinition(TestStepDefinition testStepDefinition) {
        return testStepDefinitionRepo.createStepDefinition(testStepDefinition);
    }

    @Override
    public TestStepDefinition getStepDefinitionById(String id) {
        return testStepDefinitionRepo.getStepDefinitionById(id);
    }

    @Override
    public TestStepDefinitionList listAllStepDefinitions(int offset) {
        return new TestStepDefinitionList(testStepDefinitionRepo.listAllStepDefinitions(offset));
    }

    @Override
    public void updateTestStepDefinition(String id, TestStepDefinition testStepDefinition) {
        testStepDefinitionRepo.updateTestStepDefinition(id, testStepDefinition);
    }

    @Override
    public void deleteTestStepDefinition(String id) {
        testStepDefinitionRepo.deleteTestStepDefinition(id);
    }

    @Override
    public TestStepDefinition getStepDefinitionByStepId(String id) {
        return testStepDefinitionRepo.getStepDefinitionByStepId(id);
    }

}
