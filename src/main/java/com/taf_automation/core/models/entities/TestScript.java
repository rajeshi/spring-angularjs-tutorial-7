package com.taf_automation.core.models.entities;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testScript")
public class TestScript implements Serializable {

    @Id
    private String id;
    private String name;
    private String type;
    private List<TestStep> testSteps;
    private List<TestData> testData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<TestStep> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(List<TestStep> testSteps) {
        this.testSteps = testSteps;
    }

    public List<TestData> getTestData() {
        return testData;
    }

    public void setTestData(List<TestData> testData) {
        this.testData = testData;
    }

}
