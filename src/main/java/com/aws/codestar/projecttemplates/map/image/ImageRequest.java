package com.aws.codestar.projecttemplates.map.image;

import org.springframework.stereotype.Service;

@Service
public class ImageRequest {
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
