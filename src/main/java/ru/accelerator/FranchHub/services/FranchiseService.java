package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.accelerator.FranchHub.dto.FranchiseDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.entity.CategoryEntity;
import ru.accelerator.FranchHub.entity.FranchiseEntity;
import ru.accelerator.FranchHub.entity.LocationMapEntity;
import ru.accelerator.FranchHub.exceptions.CustomGetFranchiseInformationException;
import ru.accelerator.FranchHub.exceptions.FileListException;
import ru.accelerator.FranchHub.exceptions.FranchiseAlreadyExistException;
import ru.accelerator.FranchHub.repository.CategoryRepository;
import ru.accelerator.FranchHub.repository.FranchiseRepository;
import ru.accelerator.FranchHub.repository.MapRepository;
import ru.accelerator.FranchHub.repository.UserRepository;
import ru.accelerator.FranchHub.utils.FranchiseMapper;


import java.lang.reflect.Field;
import java.util.stream.StreamSupport;

@Service
public class FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FranchiseMapper franchiseMapper;
    @Autowired
    private ImageService imageService;
    @Autowired
    private MapRepository mapRepository;
    @Value("${photo.path}")
    private String PHOTO_PATH;

    public Iterable<FranchiseHomeScreenDTO> getAllFranchises() {
        try {
            return () -> StreamSupport.stream(franchiseRepository.findAll().spliterator(), false)
                    .map(franchiseEntity -> {
                        String[] firstPhoto;
                        try {
                            firstPhoto = imageService.listFilesInDirectory(franchiseEntity.getFranchise_id(), true);
                        } catch (FileListException e) {
                            throw new RuntimeException(e);
                        }
                        FranchiseHomeScreenDTO dto = franchiseMapper.toHomeScreenDTO(franchiseEntity);
                        dto.setPhotoName(firstPhoto.length > 0 ? firstPhoto[0] : null);
                        return dto;})
                    .iterator();
        } catch (Exception e) {
            throw new CustomGetFranchiseInformationException("Ошибка при чтении данных", e);
        }
    }

    public FranchiseDTO getDetailOfFranchise(int id) {
        try {
            FranchiseDTO franchiseDTO = franchiseMapper.tCreateDto(franchiseRepository.findById(id));
            franchiseDTO.setImages(imageService.listFilesInDirectory(id, false));
            return franchiseDTO;
        } catch (Exception e) {
            throw new CustomGetFranchiseInformationException("Ошибка при чтении данных", e);
        }
    }

    public void addFranchise(FranchiseDTO franchiseDTO)
            throws FranchiseAlreadyExistException {
        if (franchiseRepository.findByTitle(franchiseDTO.getTitle()) != null) {
            throw new FranchiseAlreadyExistException("Франшиза с таким названием уже существует");
        }

        FranchiseEntity franchiseEntity = franchiseMapper.toEntity(franchiseDTO);
        franchiseEntity.setOwner(userRepository.findById(franchiseDTO.getOwner()));
        franchiseEntity.setCategory(categoryRepository.findById(franchiseDTO.getCategory()));

        franchiseRepository.save(franchiseEntity);
    }

    public LocationMapEntity getMap(int id) {
        try {
            return mapRepository.findByFranchiseId(id);
        } catch (Exception e) {
            throw new CustomGetFranchiseInformationException("Ошибка при чтении данных", e);
        }
    }

    public void setMap(int id, LocationMapEntity locationMapEntity) {
        try {
            // Проверяем, существует ли франшиза с заданным ID
            FranchiseEntity franchiseEntity = franchiseRepository.findById(id);

            if (franchiseEntity == null) {
                throw new CustomGetFranchiseInformationException("Франшиза с ИД " + id + " не найдена");
            }

            // Получаем карту для данной франшизы
            LocationMapEntity existingMap = mapRepository.findByFranchiseId(id);

            // Если карта уже существует, обновляем её данные
            if (existingMap != null) {
                // Иначе, обновляем существующую запись
                Field[] fields = LocationMapEntity.class.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(locationMapEntity);
                    if (value != null) {
                        field.set(existingMap, value);
                    }
                }
                mapRepository.save(existingMap);
            } else {
                // Если карты еще нет, создаем новую и привязываем к франшизе
                locationMapEntity.setFranchiseId(id);
                mapRepository.save(locationMapEntity);
            }
        } catch (Exception e) {
            throw new CustomGetFranchiseInformationException("Ошибка при установке данных карты", e);
        }
    }

    public Iterable<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }
}