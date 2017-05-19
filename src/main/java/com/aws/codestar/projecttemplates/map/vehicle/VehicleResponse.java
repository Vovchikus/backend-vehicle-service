package com.aws.codestar.projecttemplates.map.vehicle;

import com.aws.codestar.projecttemplates.map.image.ImageResponse;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("vehicle")
public class VehicleResponse {

    private String id;
    private String mark;
    private String model;
    private Integer price;
    private List<ImageResponse> images;

    public List<ImageResponse> getImages() {
        return images;
    }

    public void setImages(List<ImageResponse> images) {
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
}
