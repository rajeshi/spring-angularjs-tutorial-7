package com.taf_automation.core.repositories;

import com.taf_automation.core.models.entities.TestStep;

import java.util.List;

/**
 * Created by Rajesh on 11/3/17
 */
public interface TestStepRepo {

    public TestStep findTestStep(String id); // Returns the BlogEntry or null if it can't be found

    public void deleteTestStep(String id); // Deletes the found BlogEntry or returns null if it can't be found

    /**
     * @param id the id of the BlogEntry to updateTestStep
     * @param data the BlogEntry containing the data to be used for the
     * updateTestStep
     * @return the updated BlogEntry or null if the BlogEntry with the id cannot
     * be found
     */
    public TestStep updateTestStep(String id, TestStep data);

    public TestStep createTestStep(TestStep data);

    public List<TestStep> findAllTestSteps(int offset);
}
