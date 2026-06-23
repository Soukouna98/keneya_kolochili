package com.keneya.kolochili.DTO.Response.User;

import java.time.LocalDateTime;

public record AgentDTOResponse(
        Long id,
        String nom,
        String prenom,
        String email,
        String telephone,
        String specialite,
        boolean archive,
        LocalDateTime dateCreation
        ) {}