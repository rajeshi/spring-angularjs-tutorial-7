package tutorial.rest.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

public class TestStepListResource extends ResourceSupport {

    private List<TestStepResource> testStepResource = new ArrayList<TestStepResource>();

    public List<TestStepResource> getTestStepResource() {
        return testStepResource;
    }

    public void setTestStepResource(List<TestStepResource> testStepResource) {
        this.testStepResource = testStepResource;
    }

}
