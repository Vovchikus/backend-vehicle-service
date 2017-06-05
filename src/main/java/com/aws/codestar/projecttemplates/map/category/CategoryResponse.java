package com.aws.codestar.projecttemplates.map.category;

import com.aws.codestar.projecttemplates.model.Mark;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "marks")
public class CategoryResponse {
    private List<Mark> marks;

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
