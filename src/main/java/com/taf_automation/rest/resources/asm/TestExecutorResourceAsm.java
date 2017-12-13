/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.models.entities.TestExecutor;
import com.taf_automation.rest.mvc.TestExecutionController;
import com.taf_automation.rest.resources.TestExecutorResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author AD87009
 */
public class TestExecutorResourceAsm extends ResourceAssemblerSupport<TestExecutor, TestExecutorResource> {

    public TestExecutorResourceAsm() {
        super(TestExecutionController.class, TestExecutorResource.class);
    }

    @Override
    public TestExecutorResource toResource(TestExecutor t) {
        TestExecutorResource testExecutorResource = new TestExecutorResource();
        testExecutorResource.setConfigurationId(t.getConfigurationId());
        testExecutorResource.setTestScriptId(t.getTestScriptId());
        testExecutorResource.setTestExecutorId(t.getTestExecutorId());
        testExecutorResource.add(linkTo(TestExecutionController.class).slash(t.getTestExecutorId()).withSelfRel());
        return testExecutorResource;
    }

}
