package ru.accelerator.FranchHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.entity.ImageEntity;

@Repository
public interface ImageRepository extends CrudRepository<ImageEntity, Integer> {
    ImageEntity findById (int id);
}
