package com.aws.codestar.projecttemplates.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Vehicle {
    @Id
    public String id;

    public String mark;

    public String model;

    public Integer price;

    public List<Image> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark.toUpperCase();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model.toUpperCase();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
