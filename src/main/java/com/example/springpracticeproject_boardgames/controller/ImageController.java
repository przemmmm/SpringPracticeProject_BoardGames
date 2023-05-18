package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.service.BoardGameService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;
@RestController
public class ImageController {


    @GetMapping("/images/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {

        try {
            File file = new File(BoardGameService.UPLOAD_LOCATION + fileName);
            if (!file.exists() || !file.isFile()) {

                return ResponseEntity.notFound()
                        .build();
            }
            Resource resource = new UrlResource(file.toURI());

            return ResponseEntity.ok(resource);
        } catch (MalformedURLException e) {
            //return error
            return ResponseEntity.badRequest()
                    .build();
        }
    }
}

