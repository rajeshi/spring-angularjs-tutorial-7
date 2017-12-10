package com.taf_automation.core.models.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rajesh
 */
@Document(collection = "locators")
public class Locator implements Serializable {

    @Id
    private String locatorId;
    private String pageId;
    private String locatorBy;
    private String value;

    public String getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getLocatorBy() {
        return locatorBy;
    }

    public void setLocatorBy(String locatorBy) {
        this.locatorBy = locatorBy;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
