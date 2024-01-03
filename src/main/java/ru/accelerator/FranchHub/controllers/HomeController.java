package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.entity.CategoryEntity;
import ru.accelerator.FranchHub.entity.LocationMapEntity;
import ru.accelerator.FranchHub.exceptions.CustomGetFranchiseInformationException;
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

    @PostMapping("/setMap")
    public ResponseEntity<String> setFranchiseMap(@RequestBody LocationMapEntity locationMapEntity,
                                                  @RequestParam int franchise_id) {
        try {
            franchiseService.setMap(franchise_id, locationMapEntity);
            return ResponseEntity.ok("Карта успешно добавлена!");
        } catch (CustomGetFranchiseInformationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Франшиза не найдена");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/setMap")
    public ResponseEntity<String> putFranchiseMap(@RequestBody LocationMapEntity locationMapEntity,
                                                  @RequestParam int franchise_id) {
        try {
            franchiseService.setMap(franchise_id, locationMapEntity);
            return ResponseEntity.ok("Карта успешно добавлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/getMap")
    public ResponseEntity<LocationMapEntity> getFranchiseMap(@RequestParam int franchise_id/*@PathVariable int franchise_id*/) {
        return ResponseEntity.ok(franchiseService.getMap(franchise_id));
    }

    @GetMapping("/getCategories")
    public ResponseEntity<Iterable<CategoryEntity>> getCategories() {
        return ResponseEntity.ok(franchiseService.getCategories());
    }
}
