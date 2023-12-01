package ru.accelerator.FranchHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.entity.LocationMapEntity;

@Repository
public interface MapRepository extends CrudRepository<LocationMapEntity, Integer> {
    LocationMapEntity findByFranchiseId(int id);
}
