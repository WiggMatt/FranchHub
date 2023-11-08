package ru.accelerator.FranchHub.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.entity.ImageEntity;

import java.io.IOException;

@Component
public class ImageMapper {
    public static ImageEntity toImageEntity(MultipartFile file) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());
        image.setImageData(file.getBytes());
        return image;
    }
}
