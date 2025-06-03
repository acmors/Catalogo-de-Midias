package com.catalogo.CatalogoDeMidias.controller;

import com.catalogo.CatalogoDeMidias.model.Media;
import com.catalogo.CatalogoDeMidias.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaWebController {

    private final MediaService mediaService;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("media", new Media());
        return "mediaForm";
    }

    @PostMapping("/save")
    public String saveMedia(@ModelAttribute Media media,
                            @RequestParam("image") MultipartFile file) throws IOException {
        mediaService.createMediaWithImage(media, file);
        return "redirect:/media/list";
    }

    @GetMapping("/list")
    public String listMedias(Model model) {
        model.addAttribute("medias", mediaService.listAllMedia());
        return "mediaList";
    }
}

