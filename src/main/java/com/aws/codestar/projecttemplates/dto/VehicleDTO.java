package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.model.Photo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@JsonRootName("vehicles")
public final class VehicleDTO implements Serializable {

    private String id;

    @NotEmpty
    @Size(max = 255)
    @JsonProperty("title")
    private String title;

    @Size(max = 1000)
    @JsonProperty("description")
    private String description;

    @JsonProperty("photos")
    private List<Photo> photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
