package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accelerator.FranchHub.exceptions.AuthorizationException;
import ru.accelerator.FranchHub.exceptions.UserAlreadyExistException;
import ru.accelerator.FranchHub.entity.UserEntity;
import ru.accelerator.FranchHub.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepository.findByEmail(userEntity.getEmail()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        userRepository.save(userEntity);
    }

    public boolean authorization(String email, String password) throws AuthorizationException {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Логин и пароль должны быть заполненны");
        }
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new AuthorizationException("Пользователь с таким именем не найден.");
        }

        if (!user.getPassword().equals(password)) {
            throw new AuthorizationException("Неверный пароль");
        }

        return true;
    }
}
