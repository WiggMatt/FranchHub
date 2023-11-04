package ru.accelerator.FranchHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accelerator.FranchHub.exceptions.UserAlreadyExistException;
import ru.accelerator.FranchHub.entity.UserEntity;
import ru.accelerator.FranchHub.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok().body("Пользователь был успешно сохранен!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserEntity userEntity) {
        try {
            boolean authorized = userService.authorization(userEntity.getEmail(), userEntity.getPassword());
            if (authorized) {
                return ResponseEntity.ok().body("Успешная авторизация!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный email или пароль!");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
