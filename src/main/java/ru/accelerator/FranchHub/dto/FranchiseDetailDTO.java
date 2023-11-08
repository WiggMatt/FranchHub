package ru.accelerator.FranchHub.dto;

import lombok.Data;
import ru.accelerator.FranchHub.entity.CategoryEntity;
import ru.accelerator.FranchHub.entity.ImageEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class FranchiseDetailDTO extends FranchiseCreateDTO{
    private CategoryEntity category_id;
    private List<ImageEntity> images = new ArrayList<>();
}
