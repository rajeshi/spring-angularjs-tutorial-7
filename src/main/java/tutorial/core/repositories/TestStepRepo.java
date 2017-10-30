package tutorial.core.repositories;

import tutorial.core.models.entities.TestStep;

import java.util.List;

/**
 * Created by Chris on 7/10/14.
 */
public interface TestStepRepo {

    public TestStep findTestStep(Long id); // Returns the BlogEntry or null if it can't be found

    public void deleteTestStep(Long id); // Deletes the found BlogEntry or returns null if it can't be found

    /**
     * @param id the id of the BlogEntry to updateTestStep
     * @param data the BlogEntry containing the data to be used for the
     * updateTestStep
     * @return the updated BlogEntry or null if the BlogEntry with the id cannot
     * be found
     */
    public TestStep updateTestStep(Long id, TestStep data);

    public TestStep createTestStep(TestStep data);

    public List<TestStep> findAllTestSteps();
}
