package com.taf_automation.core.models.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public class TestData implements Serializable {

    private String testStepId;
    private String key;
    private List<String> values;

    public String getTestStepId() {
        return testStepId;
    }

    public void setTestStepId(String testStepId) {
        this.testStepId = testStepId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> value) {
        this.values = value;
    }
}
