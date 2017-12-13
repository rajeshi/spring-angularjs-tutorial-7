package com.taf_automation.rest.mvc;

import com.taf_automation.core.models.entities.TestStepDefinition;
import com.taf_automation.core.services.TestStepDefinitionService;
import com.taf_automation.core.services.exceptions.TestStepDefinitionNotFoundException;
import com.taf_automation.core.services.util.TestStepDefinitionList;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.TestStepDefinitionListResource;
import com.taf_automation.rest.resources.TestStepDefinitionResource;
import com.taf_automation.rest.resources.asm.TestStepDefinitionResourceAsm;
import com.taf_automation.rest.resources.asm.TestStepDefinitionResourceListAsm;
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
@RequestMapping("/rest/api/definitions")
public class TestStepDefinitionController {

    private TestStepDefinitionService testStepDefinitionService;

    @Autowired
    public TestStepDefinitionController(TestStepDefinitionService testScriptService) {
        this.testStepDefinitionService = testScriptService;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"offset"})
    public ResponseEntity<TestStepDefinitionListResource> getAllTestStepDefinitions(@RequestParam("offset") int offset) {
        TestStepDefinitionList testStepDefinitionList = testStepDefinitionService.listAllStepDefinitions(offset);
        TestStepDefinitionListResource testStepDefinitionListRes = new TestStepDefinitionResourceListAsm().toResource(testStepDefinitionList);
        return new ResponseEntity<TestStepDefinitionListResource>(testStepDefinitionListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{testStepDefinitionId}",
            method = RequestMethod.GET)
    public ResponseEntity<TestStepDefinitionResource> getTestScriptById(@PathVariable String testStepDefinitionId) {
        TestStepDefinition testStepDefinition = testStepDefinitionService.getStepDefinitionById(testStepDefinitionId);
        if (testStepDefinition != null) {
            TestStepDefinitionResource res = new TestStepDefinitionResourceAsm().toResource(testStepDefinition);
            return new ResponseEntity<TestStepDefinitionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestStepDefinitionResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/step/{testStepDefinitionId}",
            method = RequestMethod.GET)
    public ResponseEntity<TestStepDefinitionResource> getTestStepDefinitionByTestStepId(@PathVariable String testStepId) {
        TestStepDefinition testStepDefinition = testStepDefinitionService.getStepDefinitionById(testStepId);
        if (testStepDefinition != null) {
            TestStepDefinitionResource res = new TestStepDefinitionResourceAsm().toResource(testStepDefinition);
            return new ResponseEntity<TestStepDefinitionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestStepDefinitionResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{testStepDefinitionId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<TestStepDefinitionResource> deleteScript(@PathVariable String testStepDefinitionId) {
        testStepDefinitionService.deleteTestStepDefinition(testStepDefinitionId);
        return new ResponseEntity<TestStepDefinitionResource>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TestStepDefinitionResource> createTestScript(
            @RequestBody TestStepDefinitionResource sentTestStepDefinition
    ) {
        TestStepDefinition createdBlogEntry = null;
        try {
            createdBlogEntry = testStepDefinitionService.createStepDefinition(sentTestStepDefinition.toTestStepDefinition());
            TestStepDefinitionResource createdResource = new TestStepDefinitionResourceAsm().toResource(createdBlogEntry);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<TestStepDefinitionResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (TestStepDefinitionNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
