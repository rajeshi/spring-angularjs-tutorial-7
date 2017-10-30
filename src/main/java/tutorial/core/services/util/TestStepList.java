package tutorial.core.services.util;

import tutorial.core.models.entities.TestStep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 6/28/14.
 */
public class TestStepList {

    private List<TestStep> entries = new ArrayList<TestStep>();

    public TestStepList(List<TestStep> entries) {
        this.entries = entries;
    }

    public List<TestStep> getEntries() {
        return entries;
    }

    public void setEntries(List<TestStep> entries) {
        this.entries = entries;
    }
}
