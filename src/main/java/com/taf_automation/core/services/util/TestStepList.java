package com.taf_automation.core.services.util;

import com.taf_automation.core.models.entities.TestStep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestStepList {

    private List<TestStep> entries = new ArrayList<TestStep>();

    public TestStepList(List<TestStep> entries) {
        this.entries = entries;
    }

    public List<TestStep> getEntries() {
        return entries;
    }

    public void setEntries(List<TestStep> entries) {
        this.entries = entries;
    }
}
