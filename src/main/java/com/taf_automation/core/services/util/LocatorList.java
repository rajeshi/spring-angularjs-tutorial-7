package com.taf_automation.core.services.util;

import com.taf_automation.core.models.entities.Locator;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public class LocatorList {
    private List<Locator> locators;

    public LocatorList(List<Locator> locators) {
        this.locators = locators;
    }

    public List<Locator> getLocators() {
        return locators;
    }

    public void setLocators(List<Locator> locators) {
        this.locators = locators;
    }
}
