package com.aws.codestar.projecttemplates.converter.vehicle;

import com.aws.codestar.projecttemplates.converter.image.ImageResponseConverter;
import com.aws.codestar.projecttemplates.map.image.ImageResponse;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleResponse;
import com.aws.codestar.projecttemplates.model.Image;
import com.aws.codestar.projecttemplates.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleResponseConverter {

    private ImageResponseConverter imageResponseConverter;

    @Autowired
    public VehicleResponseConverter(ImageResponseConverter imageResponseConverter) {
        this.imageResponseConverter = imageResponseConverter;
    }

    public VehicleResponse convert(Vehicle vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setMark(vehicle.getMark());
        vehicleResponse.setModel(vehicle.getModel());
        vehicleResponse.setPrice(vehicle.getPrice());
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setImages(this.getImages(vehicle));
        return vehicleResponse;
    }

    private List<ImageResponse> getImages(Vehicle vehicle) {
        List<ImageResponse> imageResponses = new ArrayList<>();
        for (Image image : vehicle.getImages()) {
            ImageResponse imageResponse = this.imageResponseConverter.convert(image);
            imageResponses.add(imageResponse);
        }
        return imageResponses;
    }
}
