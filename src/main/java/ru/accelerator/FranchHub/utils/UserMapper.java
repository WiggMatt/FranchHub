package ru.accelerator.FranchHub.utils;

import org.springframework.stereotype.Component;
import ru.accelerator.FranchHub.dto.UserDTO;
import ru.accelerator.FranchHub.entity.UserEntity;

@Component
public class UserMapper {
    public static UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userEntity.getName());
        userDTO.setSurname(userEntity.getSurname());
        userDTO.setSecond_name(userEntity.getSecond_name());
        userDTO.setPhone_number(userEntity.getPhone_number());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }
}
