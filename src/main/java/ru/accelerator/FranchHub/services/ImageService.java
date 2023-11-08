package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accelerator.FranchHub.entity.ImageEntity;
import ru.accelerator.FranchHub.repository.ImageRepository;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;


    public void saveImages(byte[] imageData) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setImageData(imageData);
        imageRepository.save(image);
    }

    public ImageEntity getImage(int id) {
        return imageRepository.findById(id);
    }

}
