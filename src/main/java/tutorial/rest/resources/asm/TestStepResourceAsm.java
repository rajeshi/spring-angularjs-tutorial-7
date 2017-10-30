package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.rest.mvc.TestStepController;
import tutorial.rest.resources.TestStepResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import tutorial.core.models.entities.TestStep;

/**
 * Created by Chris on 6/30/14.
 */
public class TestStepResourceAsm extends ResourceAssemblerSupport<TestStep, TestStepResource> {
    public TestStepResourceAsm() {
        super(TestStepController.class, TestStepResource.class);
    }

    @Override
    public TestStepResource toResource(TestStep testStep) {
        TestStepResource resource = new TestStepResource();
        resource.setTitle(testStep.getTitle());
        resource.add(linkTo(TestStepController.class).slash(testStep.getId()).withSelfRel());
        return resource;
    }
}
