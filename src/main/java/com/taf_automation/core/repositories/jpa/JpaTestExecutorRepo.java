package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.TestExecutor;
import com.taf_automation.core.repositories.TestExecutorRepo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rajesh
 */
@Repository
public class JpaTestExecutorRepo implements TestExecutorRepo{

    @Override
    public void executeScript(TestExecutor executor) {
        String configuration = executor.getConfigurationId();
        String testScript = executor.getTestScriptId();
        
        
    }
    
}
