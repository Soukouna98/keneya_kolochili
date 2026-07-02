package com.keneya.kolochili.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CategorieConseilDTORequest(
        @NotBlank(message = "Le nom de la catégorie est obligatoire")
        String nom,
        
        String description,

        @NotNull(message = "L'ID de l'admin est obligatoire")
        Integer idAdmin
) {}