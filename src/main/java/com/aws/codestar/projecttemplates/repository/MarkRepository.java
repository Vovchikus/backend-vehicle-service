package com.aws.codestar.projecttemplates.repository;

import com.aws.codestar.projecttemplates.model.Mark;
import com.aws.codestar.projecttemplates.structure.MarkList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Mark findByTitleAndModel(String title, String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        query.addCriteria(Criteria.where("models").in(model));
        return mongoTemplate.findOne(query, Mark.class);
    }

    public MarkList findAll() {
        List<Mark> marks = mongoTemplate.findAll(Mark.class);
        MarkList<Mark> markList = new MarkList<>();
        for (Mark mark : marks) {
            markList.add(mark);
        }
        return markList;
    }
}
