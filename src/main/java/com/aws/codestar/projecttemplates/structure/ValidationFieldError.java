package com.aws.codestar.projecttemplates.structure;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.validation.FieldError;

@JsonRootName("error")
public class ValidationFieldError extends FieldError {
    public ValidationFieldError(String objectName, String field, String defaultMessage) {
        super(objectName, field, defaultMessage);
    }

    public ValidationFieldError(String objectName, String field, Object rejectedValue, boolean bindingFailure, String[] codes, Object[] arguments, String defaultMessage) {
        super(objectName, field, rejectedValue, bindingFailure, codes, arguments, defaultMessage);
    }
}
