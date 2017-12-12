package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.TestExecutor;
import com.taf_automation.core.repositories.TestExecutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rajesh
 */
@Repository
public class JpaTestExecutorRepo implements TestExecutorRepo {

    @Autowired
    private MongoTemplate template;

    @Override
    public void executeScript(TestExecutor executor) {

    }

}
