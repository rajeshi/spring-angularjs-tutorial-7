package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.Page;
import com.taf_automation.core.repositories.PageRepo;
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
public class JpaPageRepo implements PageRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page createPage(Page page) {
        mongoTemplate.save(page);
        return page;
    }

    @Override
    public Page getPageById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Page.class);
    }

    @Override
    public List<Page> listAllPages(int offset) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        List<Page> pages = (ArrayList<Page>) mongoTemplate.find(query, Page.class);
        int size = pages.size();
        return offset + 10 < size ? new ArrayList(pages.subList(offset, offset + 10)) : new ArrayList(pages.subList(offset, size));
    }

    @Override
    public void updatePage(String id, Page page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePage(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Page.class);
    }

}
