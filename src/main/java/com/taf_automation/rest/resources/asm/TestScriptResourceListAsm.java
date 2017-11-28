/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.services.util.TestScriptList;
import com.taf_automation.rest.mvc.TestScriptController;
import com.taf_automation.rest.resources.TestScriptListResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class TestScriptResourceListAsm extends ResourceAssemblerSupport<TestScriptList, TestScriptListResource> {

    public TestScriptResourceListAsm() {
        super(TestScriptController.class, TestScriptListResource.class);
    }

    @Override
    public TestScriptListResource toResource(TestScriptList t) {
     TestScriptListResource resource = new TestScriptListResource();
     resource.setTestScriptResource(new TestScriptResourceAsm().toResources(t.getEntries()));
     return resource;
    } 
}
