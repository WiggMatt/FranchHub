package ru.accelerator.FranchHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.entity.FranchiseEntity;

@Repository
public interface FranchiseRepository extends CrudRepository<FranchiseEntity, Integer>, CategoryRepository {
    FranchiseEntity findById (int id);
    FranchiseEntity findByTitle (String title);
}
