package com.keneya.kolochili.DTO.Request.User;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.keneya.kolochili.Enumeration.TypeNiveau;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActivitesDTORequest(

        @NotNull(message = "L'id de l'agent est obligatoire")
        Long idAgent,

        @NotNull(message = "L'id de la catégorie est obligatoire")
        Long idCategorieActivite,

        @NotNull(message = "La date est obligatoire")
        LocalDateTime date,

        @NotBlank(message = "Le nom de l'activité est obligatoire")
        String nom,

        @NotNull(message = "Le niveau est obligatoire")
        TypeNiveau niveau,

        @NotNull(message = "La durée est obligatoire")
        LocalTime duree,

        @NotBlank(message = "La description est obligatoire")
        String description

) {
}