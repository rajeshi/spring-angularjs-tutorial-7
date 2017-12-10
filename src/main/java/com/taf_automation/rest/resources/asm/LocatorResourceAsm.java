package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.models.entities.Locator;
import com.taf_automation.rest.mvc.LocatorController;
import com.taf_automation.rest.resources.LocatorResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class LocatorResourceAsm extends ResourceAssemblerSupport<Locator, LocatorResource> {

    public LocatorResourceAsm() {
        super(LocatorController.class, LocatorResource.class);
    }

    @Override
    public LocatorResource toResource(Locator locator) {
        LocatorResource resource = new LocatorResource();
        resource.setLocatorId(locator.getLocatorId());
        resource.setLocatorBy(locator.getLocatorBy());
        resource.setPageId(locator.getPageId());
        resource.setValue(locator.getValue());
        return resource;
    }

}
