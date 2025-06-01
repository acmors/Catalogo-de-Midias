package com.catalogo.CatalogoDeMidias.service;

import com.catalogo.CatalogoDeMidias.exceptions.ResourceNotFound;
import com.catalogo.CatalogoDeMidias.model.Media;
import com.catalogo.CatalogoDeMidias.repository.MediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

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
}
