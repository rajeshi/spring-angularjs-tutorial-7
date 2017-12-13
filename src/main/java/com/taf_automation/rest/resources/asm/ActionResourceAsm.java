package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.models.entities.Action;
import com.taf_automation.rest.mvc.ActionController;
import com.taf_automation.rest.resources.ActionResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class ActionResourceAsm extends ResourceAssemblerSupport<Action, ActionResource> {

    public ActionResourceAsm() {
        super(ActionController.class, ActionResource.class);
    }

    @Override
    public ActionResource toResource(Action action) {
        ActionResource resource = new ActionResource();
        resource.setAction(action.getAction());
        resource.setActionId(action.getActionId());
        resource.setInput(action.getInput());
        resource.setOutput(action.getOutput());
        resource.setLocatorId(action.getLocatorId());
        resource.add(linkTo(ActionController.class).slash(action.getActionId()).withSelfRel());
        return resource;
    }

}
