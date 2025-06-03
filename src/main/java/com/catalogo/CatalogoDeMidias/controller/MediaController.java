package com.catalogo.CatalogoDeMidias.controller;
import com.catalogo.CatalogoDeMidias.model.Media;
import com.catalogo.CatalogoDeMidias.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @PostMapping
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {
        Media created = mediaService.createMedia(media);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<Media> createMediaWithImage(
            @RequestPart("media") Media media,
            @RequestPart("file") MultipartFile file) throws IOException {
        Media created = mediaService.createMediaWithImage(media, file);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Media> listMedia(){
        return mediaService.listAllMedia();
    }

    @GetMapping("/{id}")
    public Media findById(@PathVariable Long id){
        return mediaService.findById(id);
    }

    @PutMapping("/{id}")
    public Media updateMedia(@RequestBody Media mediaUpdate, @PathVariable Long id){
        return mediaService.updateMedia(mediaUpdate, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id){
        mediaService.deleteMedia(id);
    }

    @GetMapping("/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get("uploads/" + imageName);
            byte[] image = Files.readAllBytes(imagePath);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }
}