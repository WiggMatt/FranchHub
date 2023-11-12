package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.exceptions.FileListException;
import ru.accelerator.FranchHub.exceptions.PhotoNotFoundException;
import ru.accelerator.FranchHub.services.ImageService;

import java.io.IOException;

@RestController
@RequestMapping
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("company/{id}/photo")
    public ResponseEntity<String> companyPhotoSetter(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            imageService.saveFile(id, file);
            return ResponseEntity.ok("Файл успешно сохранен");
        } catch (IOException | FileListException e) {
            return ResponseEntity.status(500).body("Ошибка при сохранении файла");
        }
    }

    @GetMapping("company/{id}/photo/{photoName:.+}")
    public ResponseEntity<Object> companyPhotoGetter(@PathVariable int id,
                                                     @PathVariable("photoName") String photoName) throws IOException {
        try {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.ALL_VALUE)
                    .body(imageService.getPhoto(id, photoName));
        } catch (PhotoNotFoundException e){
            String errorMessage = "Файл не найден: " + photoName;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
