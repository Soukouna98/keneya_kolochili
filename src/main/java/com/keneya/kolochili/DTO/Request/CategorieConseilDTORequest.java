package com.keneya.kolochili.DTO.Request;

import jakarta.validation.constraints.NotBlank;

public record CategorieConseilDTORequest(
        @NotBlank(message = "Le nom de la catégorie est obligatoire")
        String nom,
        
        String description
) {}