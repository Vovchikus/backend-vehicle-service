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
    @JsonProperty("mark")
    private String mark;

    @Size(max = 255)
    @JsonProperty("model")
    private String model;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("images")
    private List<ImageRequest> images;

    public List<ImageRequest> getImages() {
        return images;
    }

    public void setImages(List<ImageRequest> images) {
        this.images = images;
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
