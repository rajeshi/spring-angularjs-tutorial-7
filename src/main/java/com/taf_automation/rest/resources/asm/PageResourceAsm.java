package com.taf_automation.rest.resources.asm;

import com.taf_automation.core.models.entities.Page;
import com.taf_automation.rest.mvc.PageController;
import com.taf_automation.rest.resources.PageResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author Rajesh
 */
public class PageResourceAsm extends ResourceAssemblerSupport<Page, PageResource> {

    public PageResourceAsm() {
        super(PageController.class, PageResource.class);
    }

    @Override
    public PageResource toResource(Page t) {
        PageResource resource = new PageResource();
        resource.setPageId(t.getPageId());
        return resource;
    }

}
