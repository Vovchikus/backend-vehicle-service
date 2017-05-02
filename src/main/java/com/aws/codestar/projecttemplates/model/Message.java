package com.aws.codestar.projecttemplates.model;

import org.springframework.data.annotation.Id;

public class Message {

    public static int MAX_LENGTH_DESCRIPTION = 500;
    public static int MAX_LENGTH_TITLE = 100;

    @Id
    public String id;

    public String title;

    public String description;

    public Message(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Message[id=%s, title='%s', description='%s']",
                id, title, description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
