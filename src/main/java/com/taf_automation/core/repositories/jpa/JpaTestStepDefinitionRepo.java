package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.TestStepDefinition;
import com.taf_automation.core.repositories.TestStepDefinitionRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rajesh
 */
@Repository
public class JpaTestStepDefinitionRepo implements TestStepDefinitionRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public TestStepDefinition createStepDefinition(TestStepDefinition testStepDefinition) {
        mongoTemplate.save(testStepDefinition);
        return testStepDefinition;
    }

    @Override
    public TestStepDefinition getStepDefinitionById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, TestStepDefinition.class);
    }

    @Override
    public List<TestStepDefinition> listAllStepDefinitions(int offset) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        List<TestStepDefinition> steps = (ArrayList<TestStepDefinition>) mongoTemplate.find(query, TestStepDefinition.class);
        int size = steps.size();
        return offset + 10 < size ? new ArrayList(steps.subList(offset, offset + 10)) : new ArrayList(steps.subList(offset, size));
    }

    @Override
    public void updateTestStepDefinition(String id, TestStepDefinition testStepDefinition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTestStepDefinition(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, TestStepDefinition.class);
    }

}
