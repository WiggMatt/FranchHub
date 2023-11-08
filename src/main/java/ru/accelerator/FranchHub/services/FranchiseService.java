package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.entity.FranchiseEntity;
import ru.accelerator.FranchHub.exceptions.FranchiseAlreadyExistException;
import ru.accelerator.FranchHub.utils.FranchiseMapper;
import ru.accelerator.FranchHub.repository.FranchiseRepository;
import ru.accelerator.FranchHub.utils.ImageMapper;

import java.io.IOException;
import java.util.List;
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

    //TODO: подумать над сущностью в передаваемых параметрах
    public void uploadFranchise(FranchiseEntity franchiseEntity, List<MultipartFile> multipartFiles) throws FranchiseAlreadyExistException, IOException {
        if (franchiseRepository.findByTitle(franchiseEntity.getTitle()) != null) {
            throw new FranchiseAlreadyExistException("Франшиза с таким названием уже существует");
        }

        for (MultipartFile mf: multipartFiles) {
            ImageMapper.toImageEntity(mf);
        }
        franchiseRepository.save(franchiseEntity);
    }
}
