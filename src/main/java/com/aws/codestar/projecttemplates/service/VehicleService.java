package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.map.vehicle.VehicleRequest;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleResponse;
import com.aws.codestar.projecttemplates.structure.VehicleList;

public interface VehicleService {

    VehicleResponse create(VehicleRequest vehicleRequest);

    VehicleList<VehicleResponse> findAll();

    VehicleResponse findOne(String id);

}
