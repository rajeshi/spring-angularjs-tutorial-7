package com.taf_automation.core.repositories;

import com.taf_automation.core.models.entities.TestScript;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface TestScriptRepo {
    public TestScript createTestScript(TestScript script);

    public TestScript getTestScriptById(String id);

    public List<TestScript> listAllTestScripts(int offset);

    public TestScript updateTestScript(String id, TestScript testScript);

    public void deleteTestScript(String id);

    public void executeSelectedTestScript(TestScript testScript);

    public void executeSelectedTestScripts(List<TestScript> testScript);
}
