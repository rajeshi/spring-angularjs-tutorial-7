package com.taf_automation.core.models.entities;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Rajesh on 11/3/17
 */
@Document(collection = "testStep")
public class TestStep implements Serializable {

    @Id
    private String id;

    private String title;

    private List<TestStepProperties> testStepProperties;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TestStepProperties> getTestStepProperties() {
        return testStepProperties;
    }

    public void setTestStepProperties(List<TestStepProperties> testScriptProperties) {
        this.testStepProperties = testScriptProperties;
    }
}
