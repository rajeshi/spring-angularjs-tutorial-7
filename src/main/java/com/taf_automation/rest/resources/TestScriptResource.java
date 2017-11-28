package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.TestData;
import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.core.models.entities.TestStep;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class TestScriptResource extends ResourceSupport {

    private String name;
    private String type;
    private List<TestStep> steps;
    private List<TestData> data;
    private String id;

    public String getID() {
        return id;
    }

    public void setID(String id) {
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

    public List<TestStep> getSteps() {
        return steps;
    }

    public void setSteps(List<TestStep> steps) {
        this.steps = steps;
    }

    public List<TestData> getData() {
        return data;
    }

    public void setData(List<TestData> data) {
        this.data = data;
    }
    
    public TestScript toTestScript() {
        TestScript script = new TestScript();
        script.setName(name);
        script.setId(id);
        script.setType(type);
        script.setTestData(data);
        script.setTestSteps(steps);
        return script;
    }

}
