package com.taf_automation.rest.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class TestStepDefinitionListResource extends ResourceSupport {

    private List<TestStepDefinitionResource> testStepDefinitionResource = new ArrayList<TestStepDefinitionResource>();

    public List<TestStepDefinitionResource> getTestStepDefinitionResource() {
        return testStepDefinitionResource;
    }

    public void setTestStepDefinitionResource(List<TestStepDefinitionResource> testStepDefinitionResource) {
        this.testStepDefinitionResource = testStepDefinitionResource;
    }

}
