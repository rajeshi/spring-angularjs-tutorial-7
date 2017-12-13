package com.taf_automation.rest.mvc;

import com.taf_automation.core.models.entities.Page;
import com.taf_automation.core.services.PageService;
import com.taf_automation.core.services.exceptions.PageNotFoundException;
import com.taf_automation.core.services.util.PageList;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.PageListResource;
import com.taf_automation.rest.resources.PageResource;
import com.taf_automation.rest.resources.asm.PageResourceAsm;
import com.taf_automation.rest.resources.asm.PageResourceListAsm;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Rajesh
 */
@Controller
@RequestMapping("/rest/api/pages")
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @RequestMapping(method = RequestMethod.GET, params = "offset")
    public ResponseEntity<PageListResource> getAllPages(@RequestParam("offset") int offset) {
        PageList pageList = pageService.listAllPages(offset);
        PageListResource testStepListRes = new PageResourceListAsm().toResource(pageList);
        return new ResponseEntity<PageListResource>(testStepListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{pageId}",
            method = RequestMethod.GET)
    public ResponseEntity<PageResource> getPageById(@PathVariable String pageId) {
        Page page = pageService.getPageById(pageId);
        if (page != null) {
            PageResource res = new PageResourceAsm().toResource(page);
            return new ResponseEntity<PageResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<PageResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{pageId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<PageResource> deleteScript(@PathVariable String pageId) {
        pageService.deletePage(pageId);
        return new ResponseEntity<PageResource>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PageResource> createPage(
            @RequestBody PageResource sentPage
    ) {
        Page createdBlogEntry = null;
        try {
            createdBlogEntry = pageService.createPage(sentPage.toPage());
            PageResource createdResource = new PageResourceAsm().toResource(createdBlogEntry);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<PageResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (PageNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
