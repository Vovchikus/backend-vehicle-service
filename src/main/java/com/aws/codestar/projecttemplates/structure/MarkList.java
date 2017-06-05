package com.aws.codestar.projecttemplates.structure;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;

@JsonRootName("marks")
public class MarkList<T> extends ArrayList<T> {
}
