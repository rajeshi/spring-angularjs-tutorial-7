package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.Action;
import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class ActionListResource extends ResourceSupport {

    private List<ActionResource> actions;

    public ActionListResource() {
        this.actions = new ArrayList<ActionResource>();
    }

    public List<ActionResource> getActions() {
        return actions;
    }

    public void setActions(List<ActionResource> actions) {
        this.actions = actions;
    }

}
