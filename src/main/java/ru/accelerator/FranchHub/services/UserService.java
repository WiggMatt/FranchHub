package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accelerator.FranchHub.exceptions.UserAlreadyExistException;
import ru.accelerator.FranchHub.models.UserModel;
import ru.accelerator.FranchHub.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void registration(UserModel userModel) throws UserAlreadyExistException {
        if (userRepository.findByEmail(userModel.getEmail()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        userRepository.save(userModel);
    }
}
