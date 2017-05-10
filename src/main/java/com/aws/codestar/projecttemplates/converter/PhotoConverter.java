package com.aws.codestar.projecttemplates.converter;

import com.aws.codestar.projecttemplates.model.Photo;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoConverter {

    private final ServletContext servletContext;

    @Autowired
    public PhotoConverter(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public List<Photo> convert(List<Photo> photos) {
        List<Photo> photoList = new ArrayList<>();
        for (Photo photo : photos) {
            try {
                byte[] decodedPhoto = Base64.getDecoder().decode(photo.original.getBytes("UTF-8"));

                String photoPath = servletContext.getRealPath("/") + "resources/photos/";

                String uniqueID = UUID.randomUUID().toString();

                Path path = Paths.get(photoPath + uniqueID);
                path = Files.createDirectories(path);

                String ORIGINAL = "original";
                OutputStream out = new BufferedOutputStream(new FileOutputStream(path + "/" + ORIGINAL + ".jpg"));
                out.write(decodedPhoto);
                out.close();

                File file = new File(path + "/" + ORIGINAL + ".jpg");

                BufferedImage image = ImageIO.read(file);
                BufferedImage scaledImg = Scalr.resize(
                        image,
                        Scalr.Method.QUALITY,
                        Scalr.Mode.FIT_TO_WIDTH,
                        50
                );

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                ImageIO.write(scaledImg, "jpg", stream);

                stream.flush();

                byte[] scaledImageInByte = stream.toByteArray();

                String THUMBNAIL = "thumbnail";
                OutputStream out1 = new BufferedOutputStream(new FileOutputStream(path + "/" + THUMBNAIL + ".jpg"));
                out1.write(scaledImageInByte);
                out1.close();

                photo.setOriginal(
                        "http://ec2-34-209-34-16.us-west-2.compute.amazonaws.com/resources/photos/" +
                                uniqueID + "/" + THUMBNAIL + ".jpg");
                photo.setThumbnail(
                        "http://ec2-34-209-34-16.us-west-2.compute.amazonaws.com/resources/photos/" +
                                uniqueID + "/" + ORIGINAL + ".jpg");
                photoList.add(photo);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return photoList;
    }
}
