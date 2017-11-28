package com.taf_automation.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import com.taf_automation.core.services.util.TestStepList;
import com.taf_automation.rest.mvc.TestStepController;
import com.taf_automation.rest.resources.TestStepListResource;

public class TestStepResourceListAsm extends ResourceAssemblerSupport<TestStepList, TestStepListResource> {

    public TestStepResourceListAsm() {
        super(TestStepController.class, TestStepListResource.class);
    }

    @Override
    public TestStepListResource toResource(TestStepList t) {
     TestStepListResource resource = new TestStepListResource();
     resource.setTestStepResource(new TestStepResourceAsm().toResources(t.getEntries()));
     return resource;
    }   
}