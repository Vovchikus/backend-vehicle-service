package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.model.Image;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImageProcessor {

    private ImagePathBuilder imagePathBuilder;
    private ServletContext servletContext;

    @Autowired
    public ImageProcessor(ImagePathBuilder imagePathBuilder, ServletContext servletContext) {
        this.imagePathBuilder = imagePathBuilder;
        this.servletContext = servletContext;
    }

    private BufferedImage resize(String pathToFile, Integer widthToResize) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(pathToFile));
        return Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH, widthToResize);
    }

    public void saveToFullPath(byte[] bytes, String path) throws IOException {
        FileOutputStream stream = new FileOutputStream(path);
        stream.write(bytes);
        stream.close();
    }

    public String processFromBase64(String imageInBase64) {
        String uniqueName = "";
        try {
            uniqueName = UUID.randomUUID().toString();

            byte[] converted = Base64.getDecoder().decode(imageInBase64.getBytes(StandardCharsets.UTF_8));
            Path path = this.imagePathBuilder.createDirectoryPath(uniqueName, this.servletContext.getRealPath("/"));
            String fullOriginalImagePath = this.imagePathBuilder.buildFullImagePath(
                    uniqueName,
                    Image.Name.ORIGINAL.toString(),
                    Image.DEFAULT_EXT,
                    this.servletContext.getRealPath("/")
            );
            this.saveToFullPath(converted, fullOriginalImagePath);

            BufferedImage scaledImg = this.resize(fullOriginalImagePath, Image.DEFAULT_SMALL_WIDTH);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(scaledImg, Image.DEFAULT_EXT, stream);
            stream.flush();

            String fullSmallImagePath = this.imagePathBuilder.buildFullImagePath(
                    uniqueName,
                    Image.Name.SMALL.toString(),
                    Image.DEFAULT_EXT,
                    this.servletContext.getRealPath("/")
            );

            this.saveToFullPath(stream.toByteArray(), fullSmallImagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return uniqueName;
    }
}
