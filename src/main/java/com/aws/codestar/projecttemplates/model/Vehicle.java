package com.aws.codestar.projecttemplates.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Vehicle {
    @Id
    public String id;

    public String title;

    public String description;

    public List photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getPhotos() {
        return photos;
    }

    public void setPhotos(List photos) {
        this.photos = photos;
    }
}
