package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.exception.VehicleNotFoundException;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleRequest;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleResponse;
import com.aws.codestar.projecttemplates.repository.VehicleRepository;
import com.aws.codestar.projecttemplates.service.VehicleService;
import com.aws.codestar.projecttemplates.structure.VehicleList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/vehicles", headers = "Accept=application/json")
public class VehicleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleResponse postVehicle(@RequestBody @Valid VehicleRequest vehicleRequest) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        return vehicleService.create(vehicleRequest);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public VehicleList<VehicleResponse> getVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return vehicleService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public VehicleResponse findById(@PathVariable("id") String id) {
        return vehicleService.findOne(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleVehicleNotFound(VehicleNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
