package com.catalogo.CatalogoDeMidias.model;

import com.catalogo.CatalogoDeMidias.model.ENUM.Genre;
import com.catalogo.CatalogoDeMidias.model.ENUM.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_media")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer releaseYear;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private double rating;

}
