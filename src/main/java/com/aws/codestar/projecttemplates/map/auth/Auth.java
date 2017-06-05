package com.aws.codestar.projecttemplates.map.auth;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("auth")
public class Auth {
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
