package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.entity.FranchiseEntity;
import ru.accelerator.FranchHub.exceptions.FranchiseAlreadyExistException;
import ru.accelerator.FranchHub.exceptions.UserAlreadyExistException;
import ru.accelerator.FranchHub.utils.FranchiseMapper;
import ru.accelerator.FranchHub.repository.FranchiseRepository;

import java.util.stream.StreamSupport;

@Service
public class FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    public Iterable<FranchiseDTO> readAll() {
        return () -> StreamSupport.stream(franchiseRepository.findAll().spliterator(), false)
                .map(FranchiseMapper::toDTO)
                .iterator();
    }

    public FranchiseDTO getDetail(String title) {
        return FranchiseMapper.toDTO(franchiseRepository.findByTitle(title));
    }

    //TODO: подумать над сущность в передаваемых параметрах
    public void uploadFranchise(FranchiseEntity franchiseEntity) throws FranchiseAlreadyExistException {
        if (franchiseRepository.findByTitle(franchiseEntity.getTitle()) != null) {
            throw new FranchiseAlreadyExistException("Франшиза с таким названием уже существует");
        }
        franchiseRepository.save(franchiseEntity);
    }
}
