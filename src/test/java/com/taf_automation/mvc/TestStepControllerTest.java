package com.taf_automation.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.taf_automation.core.services.util.TestStepList;
import com.taf_automation.core.models.entities.TestStepProperties;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.services.exceptions.TestStepNotFoundException;
import com.taf_automation.rest.mvc.TestStepController;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.taf_automation.core.services.TestStepService;

/**
 * Created by Rajesh on 11/3/17
 */
public class TestStepControllerTest {

    @InjectMocks
    private TestStepController controller;

    @Mock
    private TestStepService testStepService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void findAllTestSteps() throws Exception {
        List<TestStep> list = new ArrayList<TestStep>();

        TestStep testStepA = new TestStep();
        testStepA.setTitle("Title A");
        list.add(testStepA);

        TestStep testStepB = new TestStep();
        testStepB.setTitle("Title B");
        list.add(testStepB);

        TestStepList allBlogs = new TestStepList(list);

        when(testStepService.findAllTestSteps(1)).thenReturn(allBlogs);

        mockMvc.perform(get("/rest/api/steps?offset=1"))
                //andExpect(jsonPath("$.testStepResource[*].title",
                //      hasItems(endsWith("Title A"), endsWith("Title B"))))
                .andExpect(status().isOk());
    }

    @Test
    public void getBlog() throws Exception {
        TestStep testStep = new TestStep();
        testStep.setTitle("Test Title");
        testStep.setId("abcdefgh");

        when(testStepService.getTestStepById("abcdefgh")).thenReturn(testStep);

        /*mockMvc.perform(get("/rest/api/steps/1"))
                .andExpect(jsonPath("$.links[*].href",
                        hasItem(endsWith("/steps/1"))))
                .andExpect(jsonPath("$.title", is("Test Title")))
                .andExpect(status().isOk());*/
    }

    @Test
    public void getNonExistingBlog() throws Exception {
        when(testStepService.getTestStepById("abcdefgh")).thenReturn(null);

        /*mockMvc.perform(get("/rest/api/steps/abcdefgh"))
                .andExpect(status().isNotFound());*/
    }

    @Test
    public void createBlogEntryExistingBlog() throws Exception {
        TestStepProperties blog = new TestStepProperties();

        TestStep entry = new TestStep();
        entry.setTitle("Test Title");
        entry.setId("abcdefgh");

        when(testStepService.createTestStep(any(TestStep.class))).thenReturn(entry);

        /*mockMvc.perform(post("/rest/api/steps")
                .content("{\"title\":\"Test Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("rest/api/steps/1"))))
                .andExpect(header().string("Location", endsWith("rest/api/steps/1")))
                .andExpect(status().isCreated());*/
    }

    @Test
    public void createBlogEntryNonExistingBlog() throws Exception {
        when(testStepService.createTestStep(any(TestStep.class))).thenThrow(new TestStepNotFoundException());

        /*mockMvc.perform(post("/rest/api/steps/1")
                .content("{\"title\":\"Generic Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());*/
    }
}
