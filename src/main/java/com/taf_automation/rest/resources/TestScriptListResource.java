package com.taf_automation.rest.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class TestScriptListResource extends ResourceSupport{
    
    private List<TestScriptResource> testScriptResource;

    public TestScriptListResource() {
        this.testScriptResource = new ArrayList<TestScriptResource>();
    }

    public List<TestScriptResource> getTestScriptResource() {
        return testScriptResource;
    }

    public void setTestScriptResource(List<TestScriptResource> testScriptResource) {
        this.testScriptResource = testScriptResource;
    }       
}
