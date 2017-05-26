package com.aws.codestar.projecttemplates.map.error;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonRootName("errors")
public class ValidationError {

    private final List<Error> errors = new ArrayList<>();

    public ValidationError() {

    }

    public void addFieldError(String path, String message) {
        Error error = new Error(path, message);
        errors.add(error);
    }

    public List<Error> getFieldErrors() {
        return Collections.unmodifiableList(errors);
    }
}
