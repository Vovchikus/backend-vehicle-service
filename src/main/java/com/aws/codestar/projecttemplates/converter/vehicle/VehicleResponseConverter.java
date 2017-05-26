package com.aws.codestar.projecttemplates.converter.vehicle;

import com.aws.codestar.projecttemplates.map.vehicle.VehicleResponse;
import com.aws.codestar.projecttemplates.model.Image;
import com.aws.codestar.projecttemplates.model.Vehicle;
import com.aws.codestar.projecttemplates.service.ImagePathBuilder;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class VehicleResponseConverter {

    public VehicleResponse convert(Vehicle vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setMark(vehicle.getMark());
        vehicleResponse.setModel(vehicle.getModel());
        vehicleResponse.setPrice(vehicle.getPrice());
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setImages(this.convertImages(vehicle));
        vehicleResponse.setCreated(this.convertDate(vehicle.getCreated()));
        return vehicleResponse;
    }

    private List<HashMap> convertImages(Vehicle vehicle) {
        List<HashMap> imageResponses = new ArrayList<>();
        for (Image image : vehicle.getImages()) {
            HashMap<String, String> map = new HashMap<>();
            map.put(Image.Name.ORIGINAL.toString(), ImagePathBuilder.buildUrl(image.getUniqueName(), Image.Name.ORIGINAL.toString(), image.getExtension()));
            map.put(Image.Name.SMALL.toString(), ImagePathBuilder.buildUrl(image.getUniqueName(), Image.Name.SMALL.toString(), image.getExtension()));
            imageResponses.add(map);
        }
        return imageResponses;
    }

    private String convertDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
