package com.taf_automation.core.services.impl;

import com.taf_automation.core.models.entities.Locator;
import com.taf_automation.core.repositories.LocatorRepo;
import com.taf_automation.core.services.LocatorService;
import com.taf_automation.core.services.util.LocatorList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajesh
 */
@Service
public class LocatorServiceImpl implements LocatorService {
    
    @Autowired
    LocatorRepo locatorRepo;

    @Override
    public Locator createLocator(Locator locator) {
        return locatorRepo.createLocator(locator);
    }

    @Override
    public Locator getLocatorById(String id) {
        return locatorRepo.getLocatorById(id);
    }

    @Override
    public LocatorList listAllLocators(int offset) {
        return new LocatorList(locatorRepo.listAllLocators(offset));
    }

    @Override
    public void updateLocator(String id, Locator locator) {
        locatorRepo.updateLocator(id, locator);
    }

    @Override
    public void deleteLocator(String id) {
        locatorRepo.deleteLocator(id);
    }

}
