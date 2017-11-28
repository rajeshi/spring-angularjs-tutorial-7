package com.taf_automation.core.services.util;

import com.taf_automation.core.models.entities.TestScript;
import java.util.List;

public class TestScriptList {

    private List<TestScript> entries;

    public TestScriptList(List<TestScript> entries) {
        this.entries = entries;
    }

    public List<TestScript> getEntries() {
        return entries;
    }

    public void setEntries(List<TestScript> entries) {
        this.entries = entries;
    }

}
