package com.taf_automation.rest.mvc;

import com.taf_automation.core.models.entities.Action;
import com.taf_automation.core.services.ActionService;
import com.taf_automation.core.services.exceptions.ActionNotFoundException;
import com.taf_automation.core.services.util.ActionList;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.ActionListResource;
import com.taf_automation.rest.resources.ActionResource;
import com.taf_automation.rest.resources.asm.ActionResourceAsm;
import com.taf_automation.rest.resources.asm.ActionResourceListAsm;
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
@RequestMapping("/rest/api/actions")
public class ActionController {
    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @RequestMapping(method = RequestMethod.GET,params = "offset")
    public ResponseEntity<ActionListResource> getAllActions(@RequestParam("offset") int offset) {
        ActionList actionList = actionService.listAllActions(offset);
        ActionListResource testStepListRes = new ActionResourceListAsm().toResource(actionList);
        return new ResponseEntity<ActionListResource>(testStepListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{actionId}",
            method = RequestMethod.GET)
    public ResponseEntity<ActionResource> getActionById(@PathVariable String actionId) {
        Action action = actionService.getActionById(actionId);
        if (action != null) {
            ActionResource res = new ActionResourceAsm().toResource(action);
            return new ResponseEntity<ActionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ActionResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{actionId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ActionResource> deleteScript(@PathVariable String actionId) {
        actionService.deleteAction(actionId);
        return new ResponseEntity<ActionResource>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ActionResource> createAction(
            @RequestBody ActionResource sentAction
    ) {
        Action createdBlogEntry = null;
        try {
            createdBlogEntry = actionService.createAction(sentAction.toAction());
            ActionResource createdResource = new ActionResourceAsm().toResource(createdBlogEntry);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<ActionResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (ActionNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
