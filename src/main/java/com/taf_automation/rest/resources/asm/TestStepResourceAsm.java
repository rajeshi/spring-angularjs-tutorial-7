package com.taf_automation.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import com.taf_automation.rest.mvc.TestStepController;
import com.taf_automation.rest.resources.TestStepResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.taf_automation.core.models.entities.TestStep;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestStepResourceAsm extends ResourceAssemblerSupport<TestStep, TestStepResource> {

    public TestStepResourceAsm() {
        super(TestStepController.class, TestStepResource.class);
    }
    
    @Override
    public TestStepResource toResource(TestStep testStep) {
        TestStepResource resource = new TestStepResource();
        resource.setID(testStep.getId());
        resource.setTitle(testStep.getTitle());
        resource.setTestStepProperties(testStep.getTestStepProperties());
        resource.add(linkTo(TestStepController.class).slash(testStep.getId()).withSelfRel());
        return resource;
    }
}
