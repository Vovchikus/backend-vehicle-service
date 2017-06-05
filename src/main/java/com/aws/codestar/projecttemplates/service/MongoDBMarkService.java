package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.model.Mark;
import com.aws.codestar.projecttemplates.repository.MarkRepository;
import com.aws.codestar.projecttemplates.structure.MarkList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoDBMarkService implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    public Mark findMarkByTitleAndModel(String title, String model) {
        return markRepository.findByTitleAndModel(title, model);
    }

    public MarkList findAll() {
        return markRepository.findAll();
    }
}
