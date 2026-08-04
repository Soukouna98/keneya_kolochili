package com.keneya.kolochili.DTO.Request.User;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keneya.kolochili.Enumeration.TypeNiveau;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActivitesDTORequest(

        Long idAgent,

        @NotNull(message = "L'id de la catégorie est obligatoire")
        Long idCategorie,

        // Rendu optionnel ou géré par défaut côté backend
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime date,

        @NotBlank(message = "Le nom de l'activité est obligatoire")
        String nom,

        @NotNull(message = "Le niveau est obligatoire")
        TypeNiveau niveau,
        
        // Format assoupli au cas où Angular envoie "HH:mm" ou "HH:mm:ss"
        @NotNull(message = "La durée est obligatoire")
        LocalTime duree,

        @NotBlank(message = "La description est obligatoire")
        String description

) {
}
