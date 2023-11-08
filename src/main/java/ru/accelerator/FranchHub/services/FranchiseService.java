package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.dto.FranchiseCreateDTO;
import ru.accelerator.FranchHub.dto.FranchiseDetailDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.entity.FranchiseEntity;
import ru.accelerator.FranchHub.entity.ImageEntity;
import ru.accelerator.FranchHub.exceptions.FranchiseAlreadyExistException;
import ru.accelerator.FranchHub.repository.CategoryRepository;
import ru.accelerator.FranchHub.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<FranchiseHomeScreenDTO> readAll() {
        return () -> StreamSupport.stream(franchiseRepository.findAll().spliterator(), false)
                .map(FranchiseMapper::toHomeScreenDTO)
                .iterator();
    }

    //TODO: Происходит ошибка при выполнении данного метода
    public FranchiseDetailDTO getDetail(String title) {
        return FranchiseMapper.toDetailDTO(franchiseRepository.findByTitle(title));
    }

    public void uploadFranchise(FranchiseCreateDTO franchiseCreateDTO, List<MultipartFile> multipartFiles, int ownerId, int categoryId)
            throws FranchiseAlreadyExistException, IOException {
        if (franchiseRepository.findByTitle(franchiseCreateDTO.getTitle()) != null) {
            throw new FranchiseAlreadyExistException("Франшиза с таким названием уже существует");
        }

        FranchiseEntity franchiseEntity = FranchiseMapper.toCreateEntity(franchiseCreateDTO);
        franchiseEntity.setOwner(userRepository.findById(ownerId));
        franchiseEntity.setCategory_id(categoryRepository.findById(categoryId));

        for (MultipartFile mf: multipartFiles) {
            ImageEntity image = ImageMapper.toImageEntity(mf);
            addImageToProduct(image, franchiseEntity);

        }
        franchiseRepository.save(franchiseEntity);
    }

    private void addImageToProduct(ImageEntity imageEntity, FranchiseEntity franchiseEntity) {
        imageEntity.setFranchise(franchiseEntity);
        franchiseEntity.getImages().add(imageEntity);
    }
}
