package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.models.entities.TestStepDefinition;
import com.taf_automation.rest.mvc.TestStepDefinitionController;
import com.taf_automation.rest.resources.TestStepDefinitionResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class TestStepDefinitionResourceAsm extends ResourceAssemblerSupport<TestStepDefinition, TestStepDefinitionResource>{

    public TestStepDefinitionResourceAsm() {
        super(TestStepDefinitionController.class, TestStepDefinitionResource.class);
    }

    @Override
    public TestStepDefinitionResource toResource(TestStepDefinition t) {
        TestStepDefinitionResource resource = new TestStepDefinitionResource();
        resource.setTestStepId(t.getTestStepId());
        resource.setTestStepDefinitionId(t.getTestStepDefinitionId());
        resource.setActions(t.getActions());
        resource.add(linkTo(TestStepDefinitionController.class).slash(t.getTestStepDefinitionId()).withSelfRel());
        return resource;
    }
    
}
