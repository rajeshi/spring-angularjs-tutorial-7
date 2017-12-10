package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.services.util.ActionList;
import com.taf_automation.rest.mvc.ActionController;
import com.taf_automation.rest.resources.ActionListResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class ActionResourceListAsm extends ResourceAssemblerSupport<ActionList, ActionListResource> {

    public ActionResourceListAsm() {
        super(ActionController.class, ActionListResource.class);
    }

    @Override
    public ActionListResource toResource(ActionList actionList) {
        ActionListResource resource = new ActionListResource();
        resource.setActions(new ActionResourceAsm().toResources(actionList.getActions()));
        return resource;
    }

}
