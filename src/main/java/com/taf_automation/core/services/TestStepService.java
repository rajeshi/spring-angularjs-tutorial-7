package com.taf_automation.core.services;

import com.taf_automation.core.services.util.TestStepList;
import com.taf_automation.core.models.entities.TestStep;

/**
 * Created by Rajesh on 11/3/17
 */
public interface TestStepService {

    /**
     * @param data the BlogEntry containing the data to be used for creating the
     * new entity
     * @return the created BlogEntry with a generated ID
     */
    public TestStep createTestStep(TestStep data);

    public TestStepList findAllTestSteps(int offset);

    public TestStep getTestStepById(String testStepId);

    public TestStep updateTestStep(String testStepId, TestStep testStep);
    
    public void deleteTestStep(String testStepId);

}
