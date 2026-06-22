package com.keneya.kolochili.DTO.Response.User;

import java.time.LocalDateTime;

public record AdminDTOResponse(
        Long id,
        String nom,
        String prenom,
        String email,
        String telephone,
        boolean archive,
        LocalDateTime dateCreation
        ) {}