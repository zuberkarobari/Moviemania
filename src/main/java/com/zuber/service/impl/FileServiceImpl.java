package com.zuber.service.impl;

import com.zuber.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        // Use File.separator to ensure correct path separators
        String filePath = path + File.separator + fileName;
        File file = new File(filePath);
        System.out.println(filePath);

        // Create the directory if it does not exist
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs(); // Ensure directories are created
        }

        // Copy the file to the target location
        Files.copy(multipartFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {
        String filePath=path+ File.separator + fileName;
        return new FileInputStream(filePath);
    }
}
