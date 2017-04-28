package com.aws.codestar.projecttemplates;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelloWorldAppInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelloWorldAppInitializer.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldAppInitializer.class, args);
    }
}