package com.taf_automation.core.services;

import com.taf_automation.core.models.entities.Action;
import com.taf_automation.core.services.util.ActionList;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface ActionService {
    
    public Action createAction(Action action);
    
    public Action getActionById(String id);
    
    public ActionList listAllActions(int offset);
    
    public void updateAction(String id, Action action);
    
    public void deleteAction(String id);
}
