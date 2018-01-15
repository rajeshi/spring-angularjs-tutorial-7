package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.TestScript;
import java.util.List;
import java.util.Map;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class TestScriptResource extends ResourceSupport {

    private String name;
    private String type;
    private List<String> steps;
    private List<Map<String, String>> data;
    private String testScriptId;

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

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }

    public String getTestScriptId() {
        return testScriptId;
    }

    public void setTestScriptId(String testScriptId) {
        this.testScriptId = testScriptId;
    }

    public TestScript toTestScript() {
        TestScript script = new TestScript();
        script.setName(name);
        script.setTestScriptId(testScriptId);
        script.setType(type);
        script.setTestData(data);
        script.setTestStepIds(steps);
        return script;
    }

}
