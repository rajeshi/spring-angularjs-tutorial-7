package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.Page;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class PageResource extends ResourceSupport {

    private String pageId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public Page toPage() {
        Page page = new Page();
        page.setPageId(pageId);
        return page;
    }
}
