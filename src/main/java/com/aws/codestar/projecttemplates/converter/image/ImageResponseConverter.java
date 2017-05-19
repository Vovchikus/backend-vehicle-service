package com.aws.codestar.projecttemplates.converter.image;

import com.aws.codestar.projecttemplates.map.image.ImageResponse;
import com.aws.codestar.projecttemplates.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageResponseConverter {

    private Image image;

    public ImageResponse convert(Image image) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setUnique(image.getUniqueName());
        imageResponse.addImageUrl(image.getUniqueName(), Image.Name.ORIGINAL.toString(), image.getExtension());
        imageResponse.addImageUrl(image.getUniqueName(), Image.Name.SMALL.toString(), image.getExtension());
        return imageResponse;
    }
}
