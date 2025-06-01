package com.catalogo.CatalogoDeMidias.controller;
import com.catalogo.CatalogoDeMidias.model.Media;
import com.catalogo.CatalogoDeMidias.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @PostMapping
    public Media create(@RequestBody Media media){
        return mediaService.createMedia(media);
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
}
