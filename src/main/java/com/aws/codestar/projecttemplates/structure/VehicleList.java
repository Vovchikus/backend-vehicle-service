package com.aws.codestar.projecttemplates.structure;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;

@JsonRootName("vehicles")
public class VehicleList<T> extends ArrayList<T> {
}
