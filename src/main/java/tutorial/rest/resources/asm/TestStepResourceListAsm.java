package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.services.util.TestStepList;
import tutorial.rest.mvc.TestStepController;
import tutorial.rest.resources.TestStepListResource;

public class TestStepResourceListAsm extends ResourceAssemblerSupport<TestStepList, TestStepListResource> {

    public TestStepResourceListAsm() {
        super(TestStepController.class, TestStepListResource.class);
    }

    @Override
    public TestStepListResource toResource(TestStepList t) {
     TestStepListResource resource = new TestStepListResource();
     resource.setTestStepResource(new TestStepResourceAsm().toResources(t.getEntries()));
     return resource;
    }   
}