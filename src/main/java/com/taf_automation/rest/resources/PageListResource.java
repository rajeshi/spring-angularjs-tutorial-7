package com.taf_automation.rest.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class PageListResource extends ResourceSupport {

    List<PageResource> pageResources = new ArrayList<PageResource>();

    public List<PageResource> getPageResources() {
        return pageResources;
    }

    public void setPageResources(List<PageResource> pageResources) {
        this.pageResources = pageResources;
    }    
}
