package ru.accelerator.FranchHub.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByEmail (String email);
    UserEntity findById (int id);
}
