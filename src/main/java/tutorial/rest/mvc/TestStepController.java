package tutorial.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tutorial.core.models.entities.TestStep;
import tutorial.core.services.exceptions.TestStepNotFoundException;
import tutorial.rest.exceptions.NotFoundException;
import tutorial.rest.resources.TestStepResource;
import tutorial.rest.resources.asm.TestStepResourceAsm;
import tutorial.rest.resources.asm.TestStepResourceListAsm;

import java.net.URI;
import tutorial.core.services.TestStepService;
import tutorial.core.services.util.TestStepList;
import tutorial.rest.resources.TestStepListResource;

/**
 * Created by Chris on 6/28/14.
 */
@Controller
@RequestMapping("/rest/api/steps")
public class TestStepController {

    private TestStepService testScriptService;

    @Autowired
    public TestStepController(TestStepService testScriptService) {
        this.testScriptService = testScriptService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TestStepListResource> getAllTestScripts() {
        TestStepList testStepList = testScriptService.findAllTestSteps();
        TestStepListResource testStepListRes = new TestStepResourceListAsm().toResource(testStepList);
        return new ResponseEntity<TestStepListResource>(testStepListRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{testScriptId}",
            method = RequestMethod.GET)
    public ResponseEntity<TestStepResource> getTestScriptById(@PathVariable Long testScriptId) {
        TestStep blog = testScriptService.getTestStepById(testScriptId);
        if (blog != null) {
            TestStepResource res = new TestStepResourceAsm().toResource(blog);
            return new ResponseEntity<TestStepResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestStepResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TestStepResource> createTestScript(
            @RequestBody TestStepResource sentTestStep
    ) {
        TestStep createdBlogEntry = null;
        try {
            createdBlogEntry = testScriptService.createTestStep(sentTestStep.toTestStep());
            TestStepResource createdResource = new TestStepResourceAsm().toResource(createdBlogEntry);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<TestStepResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (TestStepNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
