package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.map.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/uuid", headers = "Accept=application/json")
public class AuthController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Auth getUuid() {
        String uuid = UUID.randomUUID().toString();
        Auth auth = new Auth();
        auth.setUuid(uuid);
        return auth;
    }

}
