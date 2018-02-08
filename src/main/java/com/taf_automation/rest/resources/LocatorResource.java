package com.taf_automation.rest.resources;

import com.taf_automation.core.models.entities.Locator;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rajesh
 */
public class LocatorResource extends ResourceSupport {

    private String locatorId;
    private String name;
    private String pageId;
    private String locatorBy;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


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

    public Locator toLocator() {
        Locator locator = new Locator();
        locator.setName(name);
        locator.setLocatorId(locatorId);
        locator.setLocatorBy(locatorBy);
        locator.setPageId(pageId);
        locator.setValue(value);
        return locator;
    }
}
