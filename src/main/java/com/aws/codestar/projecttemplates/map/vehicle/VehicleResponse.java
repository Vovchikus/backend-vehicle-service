package com.aws.codestar.projecttemplates.map.vehicle;

import com.aws.codestar.projecttemplates.map.image.ImageResponse;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("vehicle")
public class VehicleResponse {

    private String id;
    private String title;
    private String description;
    private List<ImageResponse> images;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
}
