package com.aws.codestar.projecttemplates.converter.image;

import com.aws.codestar.projecttemplates.map.image.ImageRequest;
import com.aws.codestar.projecttemplates.model.Image;
import com.aws.codestar.projecttemplates.service.ImageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageRequestConverter {

    @Autowired
    private ImageProcessor imageProcessor;

    public Image convert(ImageRequest imageRequest) {
        Image image = new Image();
        String uniqueName = this.imageProcessor.processFromBase64(imageRequest.getSource());
        image.setUniqueName(uniqueName);
        return image;
    }
}
