package com.aws.codestar.projecttemplates.model;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Vehicle {
    @Id
    private String id;

    private String mark;

    private String model;

    private Integer price;

    private List<Image> images;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date created;

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
        this.mark = Character.toUpperCase(mark.charAt(0)) + mark.toLowerCase().substring(1);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = Character.toUpperCase(model.charAt(0)) + model.toLowerCase().substring(1);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
