package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.services.util.PageList;
import com.taf_automation.rest.mvc.PageController;
import com.taf_automation.rest.resources.PageListResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class PageResourceListAsm extends ResourceAssemblerSupport<PageList, PageListResource> {
    
    public PageResourceListAsm() {
        super(PageController.class, PageListResource.class);
    }
    
    @Override
    public PageListResource toResource(PageList t) {
        PageListResource resource = new PageListResource();
        resource.setPageResources(new PageResourceAsm().toResources(t.getPages()));
        return resource;
    }
    
}
