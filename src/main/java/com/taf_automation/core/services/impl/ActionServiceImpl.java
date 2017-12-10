package com.taf_automation.core.services.impl;

import com.taf_automation.core.models.entities.Action;
import com.taf_automation.core.repositories.ActionRepo;
import com.taf_automation.core.services.ActionService;
import com.taf_automation.core.services.util.ActionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajesh
 */
@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionRepo actionRepo;

    @Override
    public Action createAction(Action action) {
        return actionRepo.createAction(action);
    }

    @Override
    public Action getActionById(String id) {
        return actionRepo.getActionById(id);
    }

    @Override
    public ActionList listAllActions(int offset) {
        return new ActionList(actionRepo.listAllActions(offset));
    }

    @Override
    public void updateAction(String id, Action action) {
        actionRepo.updateAction(id, action);
    }

    @Override
    public void deleteAction(String id) {
        actionRepo.deleteAction(id);
    }

}
