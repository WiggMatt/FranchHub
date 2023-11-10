package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.exceptions.PhotoNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class ImageService {

    @Value("${photo.path}")
    private String PHOTO_PATH;

    public void saveFile(int id, MultipartFile file) throws IOException {
        // Проверка, что директория существует или создать её
        Path directoryPath = Paths.get(PHOTO_PATH, String.valueOf(id));
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        // Создание порядкового имени файла
        String fileName = getNextFileName(directoryPath, Objects.requireNonNull(file.getOriginalFilename()));
        // Полный путь к файлу
        Path filePath = directoryPath.resolve(fileName);
        // Копирование файла в указанное место
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        listFilesInDirectory(id);
    }

    private String getNextFileName(Path directory, String originalFilename) throws IOException {
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        int fileCount = Files.list(directory).mapToInt(path -> 1).sum() + 1;
        System.out.println(Files.list(directory));
        return fileCount + extension;
    }

    public String[] listFilesInDirectory(int id) {
        Path directoryPath = Paths.get(PHOTO_PATH, String.valueOf(id));
        String[] files = null;
        try {
            files = Files.list(directoryPath)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }


    public Resource getPhoto(int id, String photoName) throws IOException {
        Path photoPath = Path.of(PHOTO_PATH, String.valueOf(id), photoName);
        Resource photoResource = new UrlResource(photoPath.toUri());
        if (photoResource.exists() && photoResource.isReadable()) {
            return photoResource;
        } else {
            throw new PhotoNotFoundException("Файл фото не найден или недоступен для чтения");
        }
    }

}