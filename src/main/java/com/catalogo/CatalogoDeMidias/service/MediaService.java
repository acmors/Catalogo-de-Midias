package com.catalogo.CatalogoDeMidias.service;

import com.catalogo.CatalogoDeMidias.exceptions.ResourceNotFound;
import com.catalogo.CatalogoDeMidias.model.Media;
import com.catalogo.CatalogoDeMidias.repository.MediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;
    private static final String FOLDER_PATH = "uploads/";

    public Media createMedia(Media media){
        return mediaRepository.save(media);
    }

    public List<Media> listAllMedia(){
        return mediaRepository.findAll();
    }

    public Media findById(Long id){
       return mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Midia não encontrada."));
    }

    public Media updateMedia(Media mediaUpdate, Long id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Media não encontrata"));

        media.setTitle(mediaUpdate.getTitle());
        media.setDescription(mediaUpdate.getDescription());
        media.setReleaseYear(mediaUpdate.getReleaseYear());
        media.setType(mediaUpdate.getType());
        media.setGenre(mediaUpdate.getGenre());
        media.setRating(mediaUpdate.getRating());

        return mediaRepository.save(media);
        
    }

    public void deleteMedia(Long id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Midia não encontrada."));

        mediaRepository.delete(media);
    }

    public Media createMediaWithImage(Media media, MultipartFile file) throws IOException {
        Path folderPath = Paths.get(FOLDER_PATH);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = folderPath.resolve(fileName);
        Files.write(filePath, file.getBytes());

        media.setImagePath(fileName);

        return mediaRepository.save(media);
    }
}
