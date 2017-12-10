package com.taf_automation.core.models.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rajesh
 */
@Document(collection = "testExecutor")
public class TestExecutor implements Serializable {

    @Id
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
}
