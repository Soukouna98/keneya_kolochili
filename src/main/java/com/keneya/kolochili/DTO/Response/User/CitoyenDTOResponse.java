package com.keneya.kolochili.DTO.Response.User;

import java.time.LocalDateTime;

public record CitoyenDTOResponse(
        Long id,
        String nom,
        String prenom,
        String email,
        String telephone,
        LocalDateTime date_naissance,
        boolean archive,
        LocalDateTime dateCreation
        ) {}