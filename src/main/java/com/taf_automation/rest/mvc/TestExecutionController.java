package com.taf_automation.rest.mvc;

import com.taf_automation.core.models.entities.TestExecutor;
import com.taf_automation.core.services.TestExecutorService;
import com.taf_automation.core.services.exceptions.PageNotFoundException;
import com.taf_automation.rest.exceptions.NotFoundException;
import com.taf_automation.rest.resources.PageResource;
import com.taf_automation.rest.resources.TestExecutorResource;
import com.taf_automation.rest.resources.asm.PageResourceAsm;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author AD87009
 */
@Controller
@RequestMapping("/rest/api/execute")
public class TestExecutionController {

    private final TestExecutorService testExecutorService;

    @Autowired
    public TestExecutionController(TestExecutorService testExecutorService) {
        this.testExecutorService = testExecutorService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void executeTestScripts(
            @RequestBody TestExecutorResource sentPage
    ) {
        try {
            testExecutorService.executeTests(sentPage.toTestExecutor());
        } catch (PageNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
