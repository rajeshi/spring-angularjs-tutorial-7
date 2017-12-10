package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.Locator;
import com.taf_automation.core.repositories.LocatorRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rajesh
 */
@Repository
public class JpaLocatorRepo implements LocatorRepo{
    
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Locator createLocator(Locator locator) {
        mongoTemplate.save(locator);
        return locator;
    }

    @Override
    public Locator getLocatorById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Locator.class);
    }

    @Override
    public List<Locator> listAllLocators(int offset) {
Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        List<Locator> locators = (ArrayList<Locator>) mongoTemplate.find(query, Locator.class);
        int size = locators.size();
        return offset + 10 < size ? new ArrayList(locators.subList(offset, offset + 10)) : new ArrayList(locators.subList(offset, size));
    }

    @Override
    public void updateLocator(String id, Locator locator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLocator(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Locator.class);
    }
    
}
