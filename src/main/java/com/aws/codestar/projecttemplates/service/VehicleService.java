package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.dto.VehicleDTO;
import com.aws.codestar.projecttemplates.structure.VehicleList;

public interface VehicleService {

    VehicleDTO create(VehicleDTO todo);

    VehicleList<VehicleDTO> findAll();

    VehicleDTO findById(String id);

}
