package com.keneya.kolochili.DTO.Response; 

public record CategorieConseilDTOResponse(
        Long id,
        String nom,
        String description,
        boolean archive,
        Long idAdmin
) {}