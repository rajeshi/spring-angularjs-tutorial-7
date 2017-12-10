package com.taf_automation.core.services;

import com.taf_automation.core.models.entities.Locator;
import com.taf_automation.core.services.util.LocatorList;

/**
 *
 * @author Rajesh
 */
public interface LocatorService {

    public Locator createLocator(Locator locator);

    public Locator getLocatorById(String id);

    public LocatorList listAllLocators(int offset);

    public void updateLocator(String id, Locator locator);

    public void deleteLocator(String id);
}
