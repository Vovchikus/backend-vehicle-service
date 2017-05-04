package com.aws.codestar.projecttemplates.exception;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException() {
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
