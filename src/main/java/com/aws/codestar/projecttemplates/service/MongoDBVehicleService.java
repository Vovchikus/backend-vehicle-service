package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.converter.PhotoConverter;
import com.aws.codestar.projecttemplates.dto.VehicleDTO;
import com.aws.codestar.projecttemplates.exception.VehicleNotFoundException;
import com.aws.codestar.projecttemplates.model.Vehicle;
import com.aws.codestar.projecttemplates.repository.VehicleRepository;
import com.aws.codestar.projecttemplates.structure.VehicleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class MongoDBVehicleService implements VehicleService {

    private final VehicleRepository repository;
    private final PhotoConverter photoConverter;

    @Autowired
    MongoDBVehicleService(VehicleRepository repository, PhotoConverter photoConverter) {
        this.repository = repository;
        this.photoConverter = photoConverter;
    }

    public VehicleDTO create(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setTitle(vehicleDTO.getTitle());
        vehicle.setDescription(vehicleDTO.getDescription());
        vehicle.setPhotos(photoConverter.convert(vehicleDTO.getPhotos()));
        vehicle = repository.save(vehicle);
        return convertToDTO(vehicle);
    }

    @Override
    public VehicleList<VehicleDTO> findAll() {
        List<Vehicle> vehicles = repository.findAll();
        List<VehicleDTO> vehicleDTOList = convertToDTOs(vehicles);
        VehicleList<VehicleDTO> list = new VehicleList<>();
        for (VehicleDTO item : vehicleDTOList) {
            list.add(item);
        }
        return list;
    }

    @Override
    public VehicleDTO findById(String id) {
        Vehicle found = findVehicleById(id);
        return convertToDTO(found);
    }

    private List<VehicleDTO> convertToDTOs(List<Vehicle> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    private VehicleDTO convertToDTO(Vehicle model) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(model.getId());
        vehicleDTO.setTitle(model.getTitle());
        vehicleDTO.setDescription(model.getDescription());
        vehicleDTO.setPhotos(model.getPhotos());
        return vehicleDTO;
    }

    private Vehicle findVehicleById(String id) throws VehicleNotFoundException {
        Optional<Vehicle> result = Optional.ofNullable(repository.findOne(id));
        return result.orElseThrow(() -> new VehicleNotFoundException());
    }
}
