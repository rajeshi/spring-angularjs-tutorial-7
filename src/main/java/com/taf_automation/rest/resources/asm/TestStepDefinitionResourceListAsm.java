package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.services.util.TestStepDefinitionList;
import com.taf_automation.rest.mvc.TestStepDefinitionController;
import com.taf_automation.rest.resources.TestStepDefinitionListResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class TestStepDefinitionResourceListAsm extends ResourceAssemblerSupport<TestStepDefinitionList, TestStepDefinitionListResource> {

    public TestStepDefinitionResourceListAsm() {
        super(TestStepDefinitionController.class, TestStepDefinitionListResource.class);
    }

    @Override
    public TestStepDefinitionListResource toResource(TestStepDefinitionList t) {
        TestStepDefinitionListResource resource = new TestStepDefinitionListResource();
        resource.setTestStepDefinitionResource(new TestStepDefinitionResourceAsm().toResources(t.getTestStepDefinitions()));
        return resource;
    }

}
