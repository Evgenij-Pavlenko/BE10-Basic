package de.telran.service;

import de.telran.entity.ActionableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    ConfigService configService;

    public FileService(ConfigService configService) {
        this.configService = configService;
    }

    public List<String> loadStringsFromFile(String fileName) {
        try {
            return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    public void saveImageAsFile(ActionableImage image) {

        try {
            ImageIO.write(image.getImage(), "jpg", new File(configService.getPathToSavedImages() + createFileName(image)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/1a.jpg -> s3-eu-west-1.amazonaws.com.lukaroundimg.beelitz2017.1a.jpg
    private static String createFileName(ActionableImage image) {
        int indexFirst = image.getSourceUrl().indexOf('/') + 2; // cut "html://"
        return "img_" + image.getSourceUrl().substring(indexFirst).replaceAll("/", ".");
    }
}


