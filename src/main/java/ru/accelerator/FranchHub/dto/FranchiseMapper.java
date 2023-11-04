package ru.accelerator.FranchHub.dto;

import org.springframework.stereotype.Component;
import ru.accelerator.FranchHub.entity.FranchiseEntity;

@Component
public class FranchiseMapper {
    public static FranchiseDTO toDTO(FranchiseEntity franchiseEntity) {
        FranchiseDTO franchiseDTO = new FranchiseDTO();
        franchiseDTO.setTitle(franchiseEntity.getTitle());
        franchiseDTO.setMin_coast(franchiseEntity.getMin_coast());
        franchiseDTO.setCategory(franchiseEntity.getCategory_id().getTitle());
        franchiseDTO.setShort_desc(franchiseEntity.getShort_desc());
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
