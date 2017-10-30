package tutorial.core.services;

import tutorial.core.services.util.TestStepList;
import tutorial.core.models.entities.TestStep;

/**
 * Created by Chris on 6/28/14.
 */
public interface TestStepService {

    /**
     * @param data the BlogEntry containing the data to be used for creating the
     * new entity
     * @return the created BlogEntry with a generated ID
     */
    public TestStep createTestStep(TestStep data);

    public TestStepList findAllTestSteps();

    public TestStep getTestStepById(Long testStepId);

    public TestStep updateTestStep(Long testStepId, TestStep testStep);
    
    public void deleteTestStep(Long testStepId);

}
