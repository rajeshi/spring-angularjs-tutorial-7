package com.taf_automation.core.services.util;

import com.taf_automation.core.models.entities.Action;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public class ActionList {

    private List<Action> actions;

    public ActionList(List<Action> actions) {
        this.actions = actions;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
