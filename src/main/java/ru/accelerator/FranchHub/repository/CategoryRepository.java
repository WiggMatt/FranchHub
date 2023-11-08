package ru.accelerator.FranchHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    CategoryEntity findById(int id);
}
