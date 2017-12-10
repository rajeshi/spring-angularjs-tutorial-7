package com.taf_automation.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.services.exceptions.TestStepNotFoundException;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.TestStepResource;
import com.taf_automation.rest.resources.asm.TestStepResourceAsm;
import com.taf_automation.rest.resources.asm.TestStepResourceListAsm;

import java.net.URI;
import com.taf_automation.core.services.TestStepService;
import com.taf_automation.core.services.util.TestStepList;
import com.taf_automation.rest.resources.TestStepListResource;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Rajesh on 11/3/17
 */
@Controller
@RequestMapping("/rest/api/steps")
public class TestStepController {

    private TestStepService testStepService;

    @Autowired
    public TestStepController(TestStepService testScriptService) {
        this.testStepService = testScriptService;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"offset"})
    public ResponseEntity<TestStepListResource> getAllTestSteps(@RequestParam("offset") int offset) {
        TestStepList testStepList = testStepService.findAllTestSteps(offset);
        TestStepListResource testStepListRes = new TestStepResourceListAsm().toResource(testStepList);
        return new ResponseEntity<TestStepListResource>(testStepListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{testStepId}",
            method = RequestMethod.GET)
    public ResponseEntity<TestStepResource> getTestScriptById(@PathVariable String testStepId) {
        TestStep testStep = testStepService.getTestStepById(testStepId);
        if (testStep != null) {
            TestStepResource res = new TestStepResourceAsm().toResource(testStep);
            return new ResponseEntity<TestStepResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestStepResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{testStepId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<TestStepResource> deleteScript(@PathVariable String testStepId) {
        testStepService.deleteTestStep(testStepId);
        return new ResponseEntity<TestStepResource>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TestStepResource> createTestScript(
            @RequestBody TestStepResource sentTestStep
    ) {
        TestStep createdBlogEntry = null;
        try {
            createdBlogEntry = testStepService.createTestStep(sentTestStep.toTestStep());
            TestStepResource createdResource = new TestStepResourceAsm().toResource(createdBlogEntry);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<TestStepResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (TestStepNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
