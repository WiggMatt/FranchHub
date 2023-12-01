package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.entity.CategoryEntity;
import ru.accelerator.FranchHub.entity.LocationMapEntity;
import ru.accelerator.FranchHub.services.FranchiseService;


@RestController
@RequestMapping
public class HomeController {
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping("/home")
    public Iterable<FranchiseHomeScreenDTO> listFranchises() {
        return franchiseService.getAllFranchises();
    }

    @GetMapping("/detail/{franchise_id}")
    public ResponseEntity<FranchiseDTO> franchiseDetail(@PathVariable int franchise_id) {
        return ResponseEntity.ok(franchiseService.getDetailOfFranchise(franchise_id));
    }

    @PostMapping("/uploadFranchise")
    public ResponseEntity<String> uploadFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        try {
            franchiseService.addFranchise(franchiseDTO);
            return ResponseEntity.ok("Франшиза успешно добавлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PostMapping("/setMap/{franchise_id}")
    public ResponseEntity<String> setFranchiseMap(@PathVariable int franchise_id,
                                         @RequestBody LocationMapEntity locationMapEntity) {
        try {
            franchiseService.setMap(franchise_id, locationMapEntity);
            return ResponseEntity.ok("Карта успешно добавлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/getMap/{franchise_id}")
    public ResponseEntity<LocationMapEntity> getFranchiseMap(@PathVariable int franchise_id) {
        return ResponseEntity.ok(franchiseService.getMap(franchise_id));
    }

    @GetMapping("/getCategories")
    public ResponseEntity<Iterable<CategoryEntity>> getCategories() {
        return ResponseEntity.ok(franchiseService.getCategories());
    }
}
