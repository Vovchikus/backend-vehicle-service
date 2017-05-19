package com.aws.codestar.projecttemplates.map.image;

import com.aws.codestar.projecttemplates.service.ImagePathBuilder;

public class ImageUrl {

    private String url;
    private String unique;
    private String name;

    ImageUrl(String unique, String name, String extension) {
        this.unique = unique;
        this.name = name;
        this.url = ImagePathBuilder.buildUrl(unique, name, extension);
    }

    public String getUrl() {
        return url;
    }

    public String getUnique() {
        return unique;
    }

    public String getName() {
        return name;
    }
}
