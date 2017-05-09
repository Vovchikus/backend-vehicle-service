package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.dto.VehicleDTO;
import com.aws.codestar.projecttemplates.exception.VehicleNotFoundException;
import com.aws.codestar.projecttemplates.repository.VehicleRepository;
import com.aws.codestar.projecttemplates.service.VehicleService;
import com.aws.codestar.projecttemplates.structure.VehicleList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/vehicles", headers = "Accept=application/json")
public class VehicleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    private final VehicleService service;

    @Autowired
    VehicleController(VehicleService service, ApplicationContext applicationContext) {
        this.service = service;
    }

    @Autowired
    private VehicleRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public VehicleList<VehicleDTO> getMessages() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleDTO postMessage(@RequestBody @Valid VehicleDTO vehicleDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        return service.create(vehicleDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public VehicleDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleVehicleNotFound(VehicleNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
