package com.aws.codestar.projecttemplates.exception;

public class MarkNotFoundException extends RuntimeException {
    public MarkNotFoundException() {
        super("No such mark with model");
    }
}
