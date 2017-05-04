package com.aws.codestar.projecttemplates.repository;

import com.aws.codestar.projecttemplates.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
