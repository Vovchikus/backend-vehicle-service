package com.aws.codestar.projecttemplates.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException() {
        super("No todo entry found with id - ");
    }
}
