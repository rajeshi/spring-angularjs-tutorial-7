package com.taf_automation.core.models.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testScript")
public class TestScript implements Serializable {

    @Id
    private String testScriptId;
    private String name;
    private String type;
    private List<String> testStepIds;
    private List<Map<String, String>> testData;

    public String getTestScriptId() {
        return testScriptId;
    }

    public void setTestScriptId(String testScriptId) {
        this.testScriptId = testScriptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTestStepIds() {
        return testStepIds;
    }

    public void setTestStepIds(List<String> testStepIds) {
        this.testStepIds = testStepIds;
    }

    public List<Map<String, String>> getTestData() {
        return testData;
    }

    public void setTestData(List<Map<String, String>> testData) {
        this.testData = testData;
    }

}
