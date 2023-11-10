package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.services.FranchiseService;


@RestController
@RequestMapping
public class HomeController {
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping("/home")
    public Iterable<FranchiseHomeScreenDTO> listFranchises() {
        return franchiseService.readAll();
    }

    @GetMapping("/detail/{franchise_id}")
    public ResponseEntity<FranchiseDTO> franchiseDetail(@PathVariable int franchise_id) {
        return ResponseEntity.ok(franchiseService.getDetail(franchise_id));
    }

    @PostMapping("/uploadFranchise")
    public ResponseEntity<String> uploadFranchise(@ModelAttribute FranchiseDTO franchiseDTO) {
        try {

            franchiseService.uploadFranchise(franchiseDTO);
            return ResponseEntity.ok("Франшиза успешно добавлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
