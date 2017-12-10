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
    private List<String> pageObjectId;
    private List<String> actionsId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public List<String> getPageObjectId() {
        return pageObjectId;
    }

    public void setPageObjectId(List<String> pageObjectId) {
        this.pageObjectId = pageObjectId;
    }

    public List<String> getActionsId() {
        return actionsId;
    }

    public void setActionsId(List<String> actionsId) {
        this.actionsId = actionsId;
    }

    public Page toPage() {
        Page page = new Page();
        page.setPageId(pageId);
        page.setPageObjectId(pageObjectId);
        page.setActionsId(actionsId);
        return page;
    }
}
