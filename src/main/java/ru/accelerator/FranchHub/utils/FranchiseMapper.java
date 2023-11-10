package ru.accelerator.FranchHub.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.entity.CategoryEntity;
import ru.accelerator.FranchHub.entity.FranchiseEntity;
import ru.accelerator.FranchHub.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "owner", ignore = true)
    FranchiseEntity toEntity(FranchiseDTO franchiseDTO);

    FranchiseHomeScreenDTO toHomeScreenDTO(FranchiseEntity franchiseEntity);
    FranchiseDTO tCreateDto(FranchiseEntity franchiseEntity);

    default int map(UserEntity user) {
        return user == null ? 0 : user.getUser_id();
    }

    default int map(CategoryEntity category) {
        return category == null ? 0 : category.getCategory_id();
    }
}
