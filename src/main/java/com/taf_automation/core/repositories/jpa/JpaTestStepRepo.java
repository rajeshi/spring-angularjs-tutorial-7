package com.taf_automation.core.repositories.jpa;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.taf_automation.core.models.entities.TestStep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.taf_automation.core.repositories.TestStepRepo;

/**
 * Created by Rajesh on 11/3/17
 */
@Repository
public class JpaTestStepRepo implements TestStepRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public TestStep findTestStep(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, TestStep.class);
    }

    @Override
    public void deleteTestStep(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, TestStep.class);
    }

    @Override
    public TestStep updateTestStep(String id, TestStep data) {
        Query query = new Query(Criteria.where("_id").is(id));
        TestStep testStep = mongoTemplate.findOne(query, TestStep.class);
        testStep.setTitle(data.getTitle());
        testStep.setTestStepProperties(data.getTestStepProperties());
        mongoTemplate.save(testStep);
        return testStep;
    }

    @Override
    public TestStep createTestStep(TestStep data) {
        mongoTemplate.save(data);
        return data;
    }

    @Override
    public List<TestStep> findAllTestSteps(int offset) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        List<TestStep> steps = (ArrayList<TestStep>) mongoTemplate.find(query, TestStep.class);
        int size = steps.size();
        return offset + 10 < size ? new ArrayList(steps.subList(offset, offset + 10)) : new ArrayList(steps.subList(offset, size));
    }
}
