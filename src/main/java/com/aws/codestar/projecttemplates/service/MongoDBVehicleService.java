package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.converter.vehicle.VehicleRequestConverter;
import com.aws.codestar.projecttemplates.converter.vehicle.VehicleResponseConverter;
import com.aws.codestar.projecttemplates.exception.VehicleNotFoundException;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleRequest;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleResponse;
import com.aws.codestar.projecttemplates.model.Vehicle;
import com.aws.codestar.projecttemplates.repository.VehicleRepository;
import com.aws.codestar.projecttemplates.structure.VehicleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class MongoDBVehicleService implements VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Autowired
    private VehicleRequestConverter vehicleRequestConverter;

    @Autowired
    private VehicleResponseConverter vehicleResponseConverter;

    @Override
    public VehicleResponse create(VehicleRequest vehicleRequest) {
        Vehicle vehicle = repository.save(this.vehicleRequestConverter.convert(vehicleRequest));
        return this.vehicleResponseConverter.convert(vehicle);
    }

    @Override
    public VehicleList<VehicleResponse> findAll() {
        List<Vehicle> vehicles = repository.findAll(new Sort(Sort.Direction.DESC, "created"));
        VehicleList<VehicleResponse> vehicleList = new VehicleList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleList.add(this.vehicleResponseConverter.convert(vehicle));
        }
        return vehicleList;
    }

    @Override
    public VehicleResponse findOne(String id) {
        Optional<Vehicle> result = Optional.ofNullable(repository.findOne(id));
        Vehicle vehicle = result.orElseThrow(() -> new VehicleNotFoundException());
        return this.vehicleResponseConverter.convert(vehicle);
    }
}
