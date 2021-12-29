package com.examples.service;

import com.examples.exeption.FileExeption;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;


@Service
public class FileService {

    private static final int MAX_SIZE = 400000000;
    private final Path fileLocation;

    public FileService() {
        fileLocation = Paths.get("./files").toAbsolutePath().normalize();
    }

    public void saveFileInFileSystem(MultipartFile multipartFile) {
        validateFile(multipartFile);
        createDirectory();

        try {
            Path location = fileLocation.resolve(getUniqueFileName(multipartFile));
            Files.copy(multipartFile.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FileExeption("Cannot copy file");
        }
    }

    public InputStream getFileFromFileSystemByName(String fileName) {
        try {
            Path location = fileLocation.resolve(fileName);

            return Files.newInputStream(location);
        } catch (Exception e) {
            throw new FileExeption(String.format("Cannot download file %s", fileName));
        }
    }

    public String getUniqueFileName(MultipartFile multipartFile) {
        return String.format("%s_%s", LocalDateTime.now().getNano(), multipartFile.getOriginalFilename());
    }

    private void createDirectory() {
        try {
            if (!Files.exists(fileLocation)) {
                Files.createDirectory(fileLocation);
            }
        } catch (Exception e) {
            throw new FileExeption("Cannot created directory");
        }
    }

    private void validateFile(MultipartFile multipartFile) {
        if (multipartFile.getSize() > MAX_SIZE) {
            throw new FileExeption(String.format("File size %s is to big", multipartFile.getSize()));
        }
    }
}
