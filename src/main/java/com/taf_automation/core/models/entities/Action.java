package com.taf_automation.core.models.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rajesh
 */
@Document(collection = "actions")
public class Action implements Serializable {

    @Id
    private String actionId;
    private String locatorId;
    private String action;
    private String input;
    private String output;

    public String getActionId() {
        return actionId;
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

    public void setActionId(String actionId) {
        this.actionId = actionId;
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
}
