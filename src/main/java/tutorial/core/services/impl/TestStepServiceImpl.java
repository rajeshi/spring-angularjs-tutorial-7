package tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.models.entities.TestStep;
import tutorial.core.services.util.TestStepList;

import tutorial.core.services.TestStepService;
import tutorial.core.repositories.TestStepRepo;

/**
 * Created by Chris on 7/10/14.
 */
@Service
@Transactional
public class TestStepServiceImpl implements TestStepService {

    @Autowired
    private TestStepRepo testStepRepo;

    @Override
    public TestStep createTestStep(TestStep data) {
        TestStep entry = testStepRepo.createTestStep(data);
        return entry;
    }

    @Override
    public TestStepList findAllTestSteps() {
        return new TestStepList(testStepRepo.findAllTestSteps());
    }

    @Override
    public TestStep getTestStepById(Long testStepId) {
        return testStepRepo.findTestStep(testStepId);
    }

    @Override
    public TestStep updateTestStep(Long testStepId, TestStep testStep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTestStep(Long testStepId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
