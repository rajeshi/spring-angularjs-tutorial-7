package com.taf_automation.core.services;

import com.taf_automation.core.models.entities.Page;
import com.taf_automation.core.services.util.PageList;

/**
 *
 * @author Rajesh
 */
public interface PageService {

    public Page createPage(Page page);

    public Page getPageById(String id);

    public PageList listAllPages(int offset);

    public void updatePage(String id, Page page);

    public void deletePage(String id);
}
