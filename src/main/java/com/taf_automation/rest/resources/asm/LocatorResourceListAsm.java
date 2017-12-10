package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.services.util.LocatorList;
import com.taf_automation.rest.mvc.LocatorController;
import com.taf_automation.rest.resources.LocatorListResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class LocatorResourceListAsm extends ResourceAssemblerSupport<LocatorList, LocatorListResource> {

    public LocatorResourceListAsm() {
        super(LocatorController.class, LocatorListResource.class);
    }

    @Override
    public LocatorListResource toResource(LocatorList locators) {
        LocatorListResource resource = new LocatorListResource();
        resource.setLocators(new LocatorResourceAsm().toResources(locators.getLocators()));
        return resource;
    }
    
}
