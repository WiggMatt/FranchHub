package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.entity.FranchiseEntity;
import ru.accelerator.FranchHub.entity.ImageEntity;
import ru.accelerator.FranchHub.services.FranchiseService;
import ru.accelerator.FranchHub.services.TestImageService;

@RestController
@RequestMapping
public class HomeController {
    @Autowired
    private FranchiseService franchiseService;
    @Autowired
    private TestImageService testImageService;

    @GetMapping("/home")
    public Iterable<FranchiseDTO> listFranchises() {
        return franchiseService.readAll();
    }

    @GetMapping("/detail/{title}")
    public ResponseEntity<FranchiseDTO> franchiseDetail(@PathVariable String title) {
        return ResponseEntity.ok(franchiseService.getDetail(title));
    }

    //TODO: Поправить параметры метода (DTO), доделать выгрузку изображений
    @PostMapping("/uploadFranchise")
    public ResponseEntity<String> uploadFranchise(@RequestBody FranchiseEntity franchiseEntity) {
        try {

            franchiseService.uploadFranchise(franchiseEntity);
            return ResponseEntity.ok("Франшиза успешно добавлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Преобразуем MultipartFile в массив байтов
            byte[] imageData = file.getBytes();

            // Сохраняем изображение с использованием сервиса imageService
            testImageService.saveImages(imageData);

            // Возвращаем ответ с ID сохраненного изображения
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Изображение успешно загружено.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при загрузке изображения.");
        }
    }

    @GetMapping("/upload/{id}")
    public ResponseEntity<?> getImageById(@PathVariable int id) {
        return ResponseEntity.ok(testImageService.getImage(id).getImageData());
    }
}
