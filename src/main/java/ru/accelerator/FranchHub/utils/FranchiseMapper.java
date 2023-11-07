package ru.accelerator.FranchHub.utils;

import org.springframework.stereotype.Component;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.entity.FranchiseEntity;

@Component
public class FranchiseMapper {
    public static FranchiseDTO toDTO(FranchiseEntity franchiseEntity) {
        FranchiseDTO franchiseDTO = new FranchiseDTO();
        franchiseDTO.setTitle(franchiseEntity.getTitle());
        franchiseDTO.setCategory(franchiseEntity.getCategory_id().getTitle());
        return franchiseDTO;
    }

    /*public static FranchiseEntity toEntity(FranchiseDTO franchiseDTO) {
        FranchiseEntity franchiseEntity = new FranchiseEntity();
        franchiseEntity.setTitle(franchiseDTO.getTitle());
        franchiseEntity.setMin_coast(franchiseDTO.getMin_coast());
        franchiseEntity.setCategory_id(franchiseDTO.getCategory());
        franchiseEntity.setShort_desc(franchiseDTO.getShort_desc());
        return franchiseEntity;
    }*/
}
