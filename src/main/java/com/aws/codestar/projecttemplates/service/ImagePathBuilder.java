package com.aws.codestar.projecttemplates.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImagePathBuilder {

    public static final String DOMAIN = "http://localhost:8080/";
    public static final String PATH = "resources/images/";

    private StringBuilder buildImageDirectoryPath(String unique, String contextPath) {
        StringBuilder imagePath = new StringBuilder(contextPath);
        imagePath.append(PATH);
        imagePath.append(unique);
        imagePath.append("/");
        return imagePath;
    }

    public String buildFullImagePath(String unique, String name, String ext, String contextPath) {
        StringBuilder imagePath = this.buildImageDirectoryPath(unique, contextPath);
        imagePath.append(name);
        imagePath.append(".");
        imagePath.append(ext);
        return imagePath.toString();
    }

    public Path createDirectoryPath(String unique, String contextPath) throws IOException {
        Path dirPath = Paths.get(this.buildImageDirectoryPath(unique, contextPath).toString());
        return Files.createDirectories(dirPath);
    }

    public static String buildUrl(String unique, String name, String ext) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DOMAIN);
        stringBuilder.append(PATH);
        stringBuilder.append(unique);
        stringBuilder.append("/");
        stringBuilder.append(name);
        stringBuilder.append(".");
        stringBuilder.append(ext);
        return stringBuilder.toString();
    }
}
