package com.taf_automation.core.models.entities;

import java.io.Serializable;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestStepProperties implements Serializable {

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
