package com.aws.codestar.projecttemplates.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mark")
public class Mark {

    private String title;
    private List<String> models;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> model) {
        this.models = model;
    }
}
