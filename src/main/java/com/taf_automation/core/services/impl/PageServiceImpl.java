package com.taf_automation.core.services.impl;

import com.taf_automation.core.models.entities.Page;
import com.taf_automation.core.repositories.PageRepo;
import com.taf_automation.core.services.PageService;
import com.taf_automation.core.services.util.PageList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajesh
 */
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepo pageRepo;

    @Override
    public Page createPage(Page page) {
        return pageRepo.createPage(page);
    }

    @Override
    public Page getPageById(String id) {
        return pageRepo.getPageById(id);
    }

    @Override
    public PageList listAllPages(int offset) {
        return new PageList(pageRepo.listAllPages(offset));
    }

    @Override
    public void updatePage(String id, Page page) {
        pageRepo.updatePage(id, page);
    }

    @Override
    public void deletePage(String id) {
        pageRepo.deletePage(id);
    }

}
