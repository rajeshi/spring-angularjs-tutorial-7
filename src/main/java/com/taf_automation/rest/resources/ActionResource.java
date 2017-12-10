/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.Action;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class ActionResource extends ResourceSupport {

    private String actionId;
    private String locatorId;
    private String action;
    private String input;
    private String output;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Action toAction() {
        Action act = new Action();
        act.setActionId(actionId);
        act.setAction(action);
        act.setInput(input);
        act.setLocatorId(locatorId);
        act.setOutput(output);
        return act;
    }
}
