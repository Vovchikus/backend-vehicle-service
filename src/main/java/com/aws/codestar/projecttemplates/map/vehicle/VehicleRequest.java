package com.aws.codestar.projecttemplates.map.vehicle;

import com.aws.codestar.projecttemplates.map.image.ImageRequest;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Service
@JsonRootName("vehicles")
public class VehicleRequest {

    @NotEmpty()
    @Size(max = 255)
    private String mark;

    @NotEmpty()
    @Size(max = 255)
    private String model;

    @NotNull
    @NumberFormat
    private Integer price;

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
