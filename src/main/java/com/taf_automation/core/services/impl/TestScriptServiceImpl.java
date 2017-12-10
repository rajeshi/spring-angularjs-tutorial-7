package com.taf_automation.core.services.impl;

import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.core.repositories.TestScriptRepo;
import com.taf_automation.core.services.TestScriptService;
import com.taf_automation.core.services.util.TestScriptList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajesh
 */
@Service
public class TestScriptServiceImpl implements TestScriptService {

    @Autowired
    private TestScriptRepo testScriptRepo;

    @Override
    public TestScript createTestScript(TestScript script) {
        return testScriptRepo.createTestScript(script);
    }

    @Override
    public TestScript getTestScriptById(String id) {
        return testScriptRepo.getTestScriptById(id);
    }

    @Override
    public TestScriptList listAllTestScripts(int offset) {
        return new TestScriptList(testScriptRepo.listAllTestScripts(offset));
    }

    @Override
    public TestScript updateTestScript(String id, TestScript testScript) {
        return testScriptRepo.updateTestScript(id, testScript);
    }

    @Override
    public void deleteTestScript(String id) {
        testScriptRepo.deleteTestScript(id);
    }

    @Override
    public void executeSelectedTestScript(TestScript testScript) {
        testScriptRepo.executeSelectedTestScript(testScript);
    }

    @Override
    public void executeSelectedTestScripts(List<TestScript> testScript) {
        testScriptRepo.executeSelectedTestScripts(testScript);
    }

}
