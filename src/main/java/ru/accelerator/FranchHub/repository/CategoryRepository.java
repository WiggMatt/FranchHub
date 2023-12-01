package ru.accelerator.FranchHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.entity.CategoryEntity;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    CategoryEntity findById(int id);
    //List<CategoryEntity> findAll();
}
