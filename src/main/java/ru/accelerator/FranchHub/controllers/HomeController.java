package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.dto.FranchiseCreateDTO;
import ru.accelerator.FranchHub.dto.FranchiseDetailDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.services.FranchiseService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
public class HomeController {
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping("/home")
    public Iterable<FranchiseHomeScreenDTO> listFranchises() {
        return franchiseService.readAll();
    }

    @GetMapping("/detail/{title}")
    public ResponseEntity<FranchiseDetailDTO> franchiseDetail(@PathVariable String title) {
        return ResponseEntity.ok(franchiseService.getDetail(title));
    }

    @PostMapping("/uploadFranchise")
    public ResponseEntity<String> uploadFranchise(@RequestParam("files") List<MultipartFile> file,
                                                  @RequestParam("owner") int ownerId,
                                                  @RequestParam("category") int categoryId,
                                                  @ModelAttribute FranchiseCreateDTO franchiseCreateDTO) throws IOException {
        try {

            franchiseService.uploadFranchise(franchiseCreateDTO, file, ownerId, categoryId);
            return ResponseEntity.ok("Франшиза успешно добавлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

/*
    @GetMapping("/upload/{id}")
    public ResponseEntity<?> getImageById(@PathVariable int id) {
        byte[] imageData = imageService.getImage(id).getImageData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(imageData);
    }*/
}
