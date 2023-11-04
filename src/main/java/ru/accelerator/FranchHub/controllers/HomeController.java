package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.services.FranchiseService;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping
    public Iterable<FranchiseDTO> listFranchises() {
        return franchiseService.readAll();
    }

    @GetMapping("/detail/{title}")
    public ResponseEntity<FranchiseDTO> franchiseDetail(String title) {
        return ResponseEntity.ok(franchiseService.getDetail(title));
    }
}
