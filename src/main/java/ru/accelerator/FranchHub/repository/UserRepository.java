package ru.accelerator.FranchHub.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accelerator.FranchHub.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findByEmail (String email);
}
