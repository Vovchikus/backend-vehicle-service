package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.model.Mark;
import com.aws.codestar.projecttemplates.structure.MarkList;

public interface MarkService {

    Mark findMarkByTitleAndModel(String title, String model);

    MarkList findAll();
}
