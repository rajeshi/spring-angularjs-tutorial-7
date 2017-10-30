package tutorial.core.repositories.jpa;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import tutorial.core.models.entities.TestStep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import tutorial.core.repositories.TestStepRepo;

/**
 * Created by Rajesh on 10/25/17.
 */
@Repository
public class JpaTestStepRepo implements TestStepRepo {

    @Autowired
    MongoOperations mongoTemplate;

    @Override
    public TestStep findTestStep(Long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, TestStep.class);
    }

    @Override
    public void deleteTestStep(Long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, TestStep.class);
    }

    @Override
    public TestStep updateTestStep(Long id, TestStep data) {
        Query query = new Query(Criteria.where("_id").is(id));
        TestStep testStep = mongoTemplate.findOne(query, TestStep.class);
        testStep.setTitle(data.getTitle());
        testStep.setTestScriptProperties(data.getTestScriptProperties());
        mongoTemplate.save(testStep);
        return testStep;
    }

    @Override
    public TestStep createTestStep(TestStep data) {
        mongoTemplate.save(data);
        return data;
    }

    @Override
    public List<TestStep> findAllTestSteps() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        return (ArrayList<TestStep>)mongoTemplate.find(query, TestStep.class);
    }
}
