package com.aws.codestar.projecttemplates.map.vehicle;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.HashMap;
import java.util.List;

@JsonRootName("vehicle")
public class VehicleResponse {

    private String id;
    private String mark;
    private String model;
    private Integer price;
    private List<HashMap> images;
    private String created;

    public List<HashMap> getImages() {
        return images;
    }

    public void setImages(List<HashMap> images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
