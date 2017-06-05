package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.service.MongoDBMarkService;
import com.aws.codestar.projecttemplates.structure.MarkList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarkController.class);

    @Autowired
    private MongoDBMarkService service;

    @RequestMapping(value = "/api/vehicles/marks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MarkList getMarks() {
        return service.findAll();
    }
}
