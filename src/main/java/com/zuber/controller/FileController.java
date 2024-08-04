package com.zuber.controller;

import com.zuber.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file/")
public class FileController {

    @Autowired
    private FileService fileService;
    @Value("${project.poster}")
    private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadMoviePoster(@RequestPart("file") MultipartFile file) {
        try {
            String fileName = fileService.uploadFile(uploadPath, file);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage() +e.getStackTrace());
        }
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getMoviePoster(@PathVariable String fileName) {
        try {
            InputStream fileStream = fileService.getResourceFile(uploadPath, fileName);
            InputStreamResource resource = new InputStreamResource(fileStream);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
