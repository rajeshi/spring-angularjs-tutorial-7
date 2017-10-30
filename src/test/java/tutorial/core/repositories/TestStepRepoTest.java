package tutorial.core.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertNotNull;
import tutorial.core.models.entities.TestStep;

/**
 * Created by Chris on 7/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class TestStepRepoTest {

    @Autowired
    private TestStepRepo repo;

    private TestStep testStep;

    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        testStep = new TestStep();
        repo.createTestStep(testStep);
    }

    @Test
    @Transactional
    public void testFind()
    {
        TestStep testStep = repo.findTestStep(this.testStep.getId());
        //assertNotNull(testStep);
    }
}
