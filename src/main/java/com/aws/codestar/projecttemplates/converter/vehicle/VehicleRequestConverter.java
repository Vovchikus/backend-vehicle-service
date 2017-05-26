package com.aws.codestar.projecttemplates.converter.vehicle;

import com.aws.codestar.projecttemplates.converter.image.ImageRequestConverter;
import com.aws.codestar.projecttemplates.map.image.ImageRequest;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleRequest;
import com.aws.codestar.projecttemplates.model.Image;
import com.aws.codestar.projecttemplates.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class VehicleRequestConverter {

    @Autowired
    private ImageRequestConverter imageRequestConverter;

    public Vehicle convert(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMark(vehicleRequest.getMark());
        vehicle.setModel(vehicleRequest.getModel());
        vehicle.setPrice(vehicleRequest.getPrice());
        vehicle.setImages(this.getImages(vehicleRequest.getImages()));
        vehicle.setCreated(new Date());
        return vehicle;
    }

    private List<Image> getImages(List<ImageRequest> imageRequests) {
        List<Image> images = new ArrayList<>();
        for (ImageRequest imageRequest : imageRequests) {
            images.add(this.imageRequestConverter.convert(imageRequest));
        }
        return images;
    }
}
