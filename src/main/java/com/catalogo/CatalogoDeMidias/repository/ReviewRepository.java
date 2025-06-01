package com.catalogo.CatalogoDeMidias.repository;

import com.catalogo.CatalogoDeMidias.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
