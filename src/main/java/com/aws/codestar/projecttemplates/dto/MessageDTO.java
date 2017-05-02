package com.aws.codestar.projecttemplates.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public final class MessageDTO {

    private String id;

    @Size(max = 100)
    private String description;

    @NotEmpty
    @Size(max = 200)
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
