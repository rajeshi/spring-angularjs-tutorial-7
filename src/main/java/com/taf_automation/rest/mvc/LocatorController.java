package com.taf_automation.rest.mvc;

import com.taf_automation.core.models.entities.Locator;
import com.taf_automation.core.services.LocatorService;
import com.taf_automation.core.services.exceptions.LocatorNotFoundException;
import com.taf_automation.core.services.util.LocatorList;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.LocatorListResource;
import com.taf_automation.rest.resources.LocatorResource;
import com.taf_automation.rest.resources.asm.LocatorResourceAsm;
import com.taf_automation.rest.resources.asm.LocatorResourceListAsm;
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
@RequestMapping("/rest/api/loctors")
public class LocatorController {

    private final LocatorService locationService;

    @Autowired
    public LocatorController(LocatorService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(method = RequestMethod.GET, params = "offset")
    public ResponseEntity<LocatorListResource> getAllLocators(@RequestParam("offset") int offset) {
        LocatorList locationList = locationService.listAllLocators(offset);
        LocatorListResource testStepListRes = new LocatorResourceListAsm().toResource(locationList);
        return new ResponseEntity<LocatorListResource>(testStepListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{locationId}",
            method = RequestMethod.GET)
    public ResponseEntity<LocatorResource> getLocatorById(@PathVariable String locationId) {
        Locator location = locationService.getLocatorById(locationId);
        if (location != null) {
            LocatorResource res = new LocatorResourceAsm().toResource(location);
            return new ResponseEntity<LocatorResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<LocatorResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{locationId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<LocatorResource> deleteScript(@PathVariable String locationId) {
        locationService.deleteLocator(locationId);
        return new ResponseEntity<LocatorResource>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LocatorResource> createLocator(
            @RequestBody LocatorResource sentLocator
    ) {
        Locator createdBlogEntry = null;
        try {
            createdBlogEntry = locationService.createLocator(sentLocator.toLocator());
            LocatorResource createdResource = new LocatorResourceAsm().toResource(createdBlogEntry);
            String link = createdResource.getLink("self").getHref();
            String id = link.substring(link.lastIndexOf("/"));
            createdResource.setLocatorId(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<LocatorResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (LocatorNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
