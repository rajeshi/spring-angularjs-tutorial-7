package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.TestScript;
import com.taf_automation.core.models.entities.TestStep;
import com.taf_automation.core.repositories.TestScriptRepo;
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
public class JpaTestScriptRepo implements TestScriptRepo {
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public TestScript createTestScript(TestScript script) {
        mongoTemplate.save(script);
        return script;
    }
    
    @Override
    public TestScript getTestScriptById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, TestScript.class);
    }
    
    @Override
    public List<TestScript> listAllTestScripts() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        return (ArrayList<TestScript>)mongoTemplate.find(query, TestScript.class);
    }
    
    @Override
    public TestScript updateTestScript(String id, TestScript data) {
         Query query = new Query(Criteria.where("_id").is(id));
        TestScript testScript = mongoTemplate.findOne(query, TestScript.class);
        testScript.setId(data.getId());
        testScript.setTestData(data.getTestData());
        testScript.setTestSteps(data.getTestSteps());
        mongoTemplate.save(testScript);
        return testScript;
    }
    
    @Override
    public void deleteTestScript(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, TestScript.class);
    }
    
    @Override
    public void executeSelectedTestScript(TestScript testScript) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void executeSelectedTestScripts(List<TestScript> testScript) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
