package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accelerator.FranchHub.exceptions.UserAlreadyExistException;
import ru.accelerator.FranchHub.models.UserModel;
import ru.accelerator.FranchHub.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserModel userModel) {
        try {
            userService.registration(userModel);
            return ResponseEntity.ok().body("Пользователь был успешно сохранен!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getHome() {
        try {
            return ResponseEntity.ok().body("Вы на вкладке users!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
