package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.rest.mvc.TestScriptController;
import com.taf_automation.rest.resources.TestScriptResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class TestScriptResourceAsm extends ResourceAssemblerSupport<TestScript, TestScriptResource> {

    public TestScriptResourceAsm() {
        super(TestScriptController.class, TestScriptResource.class);
    }

    @Override
    public TestScriptResource toResource(TestScript testScript) {
        TestScriptResource resource = new TestScriptResource();
        resource.setName(testScript.getName());
        resource.setType(testScript.getType());
        resource.setData(testScript.getTestData());
        resource.setSteps(testScript.getTestSteps());
        resource.add(linkTo(TestScriptController.class).slash(testScript.getId()).withSelfRel());
        return resource;
    }
}
