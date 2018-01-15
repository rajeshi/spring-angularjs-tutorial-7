package com.taf_automation.core.services.impl;

import com.taf_automation.core.models.entities.Action;
import com.taf_automation.core.models.entities.Locator;
import com.taf_automation.core.models.entities.TestExecutor;
import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.models.entities.TestStepDefinition;
import com.taf_automation.core.repositories.ActionRepo;
import com.taf_automation.core.repositories.LocatorRepo;
import com.taf_automation.core.repositories.TestExecutorRepo;
import com.taf_automation.core.repositories.TestScriptRepo;
import com.taf_automation.core.repositories.TestStepDefinitionRepo;
import com.taf_automation.core.repositories.TestStepRepo;
import com.taf_automation.core.services.TestExecutorService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajesh
 */
@Service
public class TestExecutorServiceImpl implements TestExecutorService {

    @Autowired
    private TestExecutorRepo testExecutorRepo;

    @Autowired
    private TestScriptRepo testScriptRepo;

    @Autowired
    private TestStepRepo testStepRepo;

    @Autowired
    private TestStepDefinitionRepo testStepDefinitionRepo;

    @Autowired
    private ActionRepo actionRepo;

    @Autowired
    private LocatorRepo locatorRepo;

    @Override
    public void executeTests(TestExecutor executor) {
        TestScript testScript = testScriptRepo.getTestScriptById(executor.getTestExecutorId());
        List<String> testStepIds = testScript.getTestStepIds();
        List<Map<String, String>> testData = testScript.getTestData();
        for (Map<String, String> row : testData) {
            for (String testStepId : testStepIds) {
                TestStep testStep = testStepRepo.findTestStep(testStepId);
                TestStepDefinition testStepDef = testStepDefinitionRepo.getStepDefinitionByStepId(testStep.getTestStepId());
                for (String actionId : testStepDef.getActions()) {
                    Action action = actionRepo.getActionById(actionId);
                    String locatorId = action.getLocatorId();
                    Locator locator = locatorRepo.getLocatorById(locatorId);
                    String locatorBy = locator.getLocatorBy();
                    String act = action.getAction();
                    String input = row.get(action.getInput());
                    //String input = row.
                }
            }
        }
    }

}
