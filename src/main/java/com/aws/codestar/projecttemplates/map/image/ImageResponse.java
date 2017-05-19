package com.aws.codestar.projecttemplates.map.image;

import java.util.ArrayList;
import java.util.List;

public class ImageResponse {

    private String unique;
    private List<ImageUrl> urls = new ArrayList<>();

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public List<ImageUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<ImageUrl> urls) {
        this.urls = urls;
    }

    public void addImageUrl(String unique, String name, String extension) {
        urls.add(new ImageUrl(unique, name, extension));
    }
}
