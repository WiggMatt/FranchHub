package ru.accelerator.FranchHub.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.FranchHub.exceptions.FileListException;
import ru.accelerator.FranchHub.exceptions.PhotoNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ImageService {

    @Value("${photo.path}")
    private String PHOTO_PATH;

    public void saveFile(int id, MultipartFile file) throws IOException, FileListException {
        try {
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

            // Вызов метода listFilesInDirectory(id) после успешного сохранения файла
            listFilesInDirectory(id, false);

        } catch (IOException e) {
            // Ловим IOException и выбрасываем его дальше
            throw e;
        } catch (Exception ex) {
            // Если произошла ошибка, связанная с вашим списком файлов, создаем и выбрасываем FileListException
            throw new FileListException("Ошибка при работе с списком файлов", ex);
        }
    }
    private String getNextFileName(Path directory, String originalFilename) throws IOException {
        try {
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            int fileCount;
            try (Stream<Path> filesStream = Files.list(directory)) {
                fileCount = filesStream.mapToInt(path -> 1).sum() + 1;
            }
            System.out.println(Files.list(directory));
            return fileCount + extension;
        } catch (IOException e) {
            throw new IOException("Ошибка при работе с файлами или директорией", e);
        }
    }


    public String[] listFilesInDirectory(int id, boolean getFirstOnly) throws FileListException {
        Path directoryPath = Paths.get(PHOTO_PATH, String.valueOf(id));
        try {
            try (Stream<Path> fileStream = Files.list(directoryPath)) {
                if (getFirstOnly) {
                    Optional<String> firstFileName = fileStream
                            .map(Path::getFileName)
                            .map(Path::toString)
                            .findFirst();
                    return firstFileName.map(name -> new String[]{name}).orElse(new String[]{});
                } else {
                    String[] fileNames = fileStream
                            .filter(Files::isRegularFile)
                            .map(Path::getFileName)
                            .map(Path::toString)
                            .toArray(String[]::new);
                    return fileNames.length > 0 ? fileNames : new String[]{};
                }
            }
        } catch (IOException e) {
            throw new FileListException("Ошибка при чтении файла из директории", e);
        }
    }



    public Resource getPhoto(int id, String photoName) throws IOException {
        Path photoPath = Path.of(PHOTO_PATH, String.valueOf(id), photoName);
        Resource photoResource = new UrlResource(photoPath.toUri());
        if (photoResource.exists() && photoResource.isReadable()) {
            return photoResource;
        } else {
            throw new PhotoNotFoundException("Файл не найден или недоступен для чтения");
        }
    }
}