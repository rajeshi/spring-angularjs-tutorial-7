package com.taf_automation.core.repositories;

import com.taf_automation.core.models.entities.Locator;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public interface LocatorRepo {

    public Locator createLocator(Locator locator);

    public Locator getLocatorById(String id);

    public List<Locator> listAllLocators(int offset);

    public void updateLocator(String id, Locator locator);

    public void deleteLocator(String id);
}
