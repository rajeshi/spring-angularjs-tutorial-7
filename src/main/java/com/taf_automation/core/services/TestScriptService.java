package com.taf_automation.core.services;

import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.core.services.util.TestScriptList;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface TestScriptService {

    public TestScript createTestScript(TestScript script);

    public TestScript getTestScriptById(String id);

    public TestScriptList listAllTestScripts(int offset);

    public TestScript updateTestScript(String id, TestScript testScript);

    public void deleteTestScript(String id);

    public void executeSelectedTestScript(TestScript testScript);

    public void executeSelectedTestScripts(List<TestScript> testScript);
}
