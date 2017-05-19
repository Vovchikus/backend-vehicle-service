package com.aws.codestar.projecttemplates.map.vehicle;

import com.aws.codestar.projecttemplates.map.image.ImageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;

@Service
@JsonRootName("vehicles")
public class VehicleRequest {

    @NotEmpty
    @Size(max = 255)
    @JsonProperty("title")
    private String title;

    @Size(max = 1000)
    @JsonProperty("description")
    private String description;

    @JsonProperty("images")
    private List<ImageRequest> images;

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

    public List<ImageRequest> getImages() {
        return images;
    }

    public void setImages(List<ImageRequest> images) {
        this.images = images;
    }
}
