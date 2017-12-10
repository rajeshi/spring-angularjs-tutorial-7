package com.taf_automation.core.repositories;

import com.taf_automation.core.models.entities.Page;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface PageRepo {

    public Page createPage(Page page);

    public Page getPageById(String id);

    public List<Page> listAllPages(int offset);

    public void updatePage(String id, Page page);

    public void deletePage(String id);
}
