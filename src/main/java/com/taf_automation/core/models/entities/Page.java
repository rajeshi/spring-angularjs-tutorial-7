package com.taf_automation.core.models.entities;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rajesh
 */
@Document(collection = "pages")
public class Page implements Serializable{
    @Id
    private String pageId;
    private List<String> pageObjectId;
    private List<String> actionsId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public List<String> getPageObjectId() {
        return pageObjectId;
    }

    public void setPageObjectId(List<String> pageObjectId) {
        this.pageObjectId = pageObjectId;
    }

    public List<String> getActionsId() {
        return actionsId;
    }

    public void setActionsId(List<String> actionsId) {
        this.actionsId = actionsId;
    }
}
