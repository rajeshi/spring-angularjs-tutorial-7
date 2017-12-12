package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.TestExecutor;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author AD87009
 */
public class TestExecutorResource extends ResourceSupport {

    private String testExecutorId;
    private String configurationId;
    private String testScriptId;

    public String getTestExecutorId() {
        return testExecutorId;
    }

    public void setTestExecutorId(String testExecutorId) {
        this.testExecutorId = testExecutorId;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getTestScriptId() {
        return testScriptId;
    }

    public void setTestScriptId(String testScriptId) {
        this.testScriptId = testScriptId;
    }

    public TestExecutor toTestExecutor() {
        TestExecutor testExecutor = new TestExecutor();
        testExecutor.setTestExecutorId(testExecutorId);
        testExecutor.setConfigurationId(configurationId);
        testExecutor.setTestScriptId(testScriptId);
        return testExecutor;
    }

}
