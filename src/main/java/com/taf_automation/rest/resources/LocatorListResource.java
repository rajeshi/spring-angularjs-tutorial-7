package com.taf_automation.rest.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class LocatorListResource extends ResourceSupport {

    private List<LocatorResource> actions;

    public LocatorListResource() {
        this.actions = new ArrayList<LocatorResource>();
    }

    public List<LocatorResource> getLocators() {
        return actions;
    }

    public void setLocators(List<LocatorResource> actions) {
        this.actions = actions;
    }

}
