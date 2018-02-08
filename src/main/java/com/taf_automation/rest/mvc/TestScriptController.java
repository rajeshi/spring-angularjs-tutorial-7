package com.taf_automation.rest.mvc;

import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.core.services.TestScriptService;
import com.taf_automation.core.services.exceptions.TestScriptNotFoundException;
import com.taf_automation.core.services.util.TestScriptList;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.TestScriptListResource;
import com.taf_automation.rest.resources.TestScriptResource;
import com.taf_automation.rest.resources.asm.TestScriptResourceAsm;
import com.taf_automation.rest.resources.asm.TestScriptResourceListAsm;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/rest/api/scripts")
public class TestScriptController {

    private final TestScriptService testScriptService;

    @Autowired
    public TestScriptController(TestScriptService testScriptService) {
        this.testScriptService = testScriptService;
    }

    @RequestMapping(method = RequestMethod.GET,params = "offset")
    public ResponseEntity<TestScriptListResource> getAllTestSteps(@RequestParam("offset") int offset) {
        TestScriptList testScriptList = testScriptService.listAllTestScripts(offset);
        TestScriptListResource testStepListRes = new TestScriptResourceListAsm().toResource(testScriptList);
        return new ResponseEntity<TestScriptListResource>(testStepListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{testScriptId}",
            method = RequestMethod.GET)
    public ResponseEntity<TestScriptResource> getTestScriptById(@PathVariable String testScriptId) {
        TestScript testScript = testScriptService.getTestScriptById(testScriptId);
        if (testScript != null) {
            TestScriptResource res = new TestScriptResourceAsm().toResource(testScript);
            return new ResponseEntity<TestScriptResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestScriptResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{testScriptId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<TestScriptResource> deleteScript(@PathVariable String testScriptId) {
        testScriptService.deleteTestScript(testScriptId);
        return new ResponseEntity<TestScriptResource>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TestScriptResource> createTestScript(
            @RequestBody TestScriptResource sentTestScript
    ) {
        TestScript createdBlogEntry = null;
        try {
            createdBlogEntry = testScriptService.createTestScript(sentTestScript.toTestScript());
            TestScriptResource createdResource = new TestScriptResourceAsm().toResource(createdBlogEntry);
            //HttpHeaders headers = new HttpHeaders();
            //headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<TestScriptResource>(createdResource, HttpStatus.CREATED);
        } catch (TestScriptNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

}
