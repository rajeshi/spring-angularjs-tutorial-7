package com.taf_automation.core.repositories.jpa;

import com.taf_automation.core.models.entities.Action;
import com.taf_automation.core.models.entities.Page;
import com.taf_automation.core.repositories.ActionRepo;
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
public class JpaActionRepo implements ActionRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Action createAction(Action action) {
        mongoTemplate.save(action);
        return action;
    }

    @Override
    public Action getActionById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Action.class);
    }

    @Override
    public List<Action> listAllActions(int offset) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        List<Action> actions = (ArrayList<Action>) mongoTemplate.find(query, Action.class);
        int size = actions.size();
        return offset + 10 < size ? new ArrayList(actions.subList(offset, offset + 10)) : new ArrayList(actions.subList(offset, size));
    }

    @Override
    public void updateAction(String id, Action action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAction(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Page.class);
    }

}
