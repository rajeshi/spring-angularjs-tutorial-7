package com.taf_automation.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.services.util.TestStepList;

import com.taf_automation.core.services.TestStepService;
import com.taf_automation.core.repositories.TestStepRepo;

/**
 * Created by Rajesh on 11/3/17
 */
@Service
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
    public TestStep getTestStepById(String testStepId) {
        return testStepRepo.findTestStep(testStepId);
    }

    @Override
    public TestStep updateTestStep(String testStepId, TestStep testStep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTestStep(String testStepId) {
        testStepRepo.deleteTestStep(testStepId);
    }
}
