package com.taf_automation.core.repositories;

import com.taf_automation.core.models.entities.Action;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface ActionRepo {

    public Action createAction(Action action);

    public Action getActionById(String id);

    public List<Action> listAllActions(int offset);

    public void updateAction(String id, Action action);

    public void deleteAction(String id);
}
