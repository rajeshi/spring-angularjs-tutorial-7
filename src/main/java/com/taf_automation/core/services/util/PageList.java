package com.taf_automation.core.services.util;

import com.taf_automation.core.models.entities.Page;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public class PageList {

    private List<Page> pages;

    public PageList(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
