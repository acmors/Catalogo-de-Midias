package com.catalogo.CatalogoDeMidias.repository;

import com.catalogo.CatalogoDeMidias.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
