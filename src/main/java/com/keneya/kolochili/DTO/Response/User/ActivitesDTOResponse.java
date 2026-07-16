package com.keneya.kolochili.DTO.Response.User;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.keneya.kolochili.Enumeration.TypeNiveau;

public record ActivitesDTOResponse(

        Long idActivites,

        String nomAgent,

        String prenomAgent,

        String categorieActivite,

        LocalDateTime date,

        String nom,

        TypeNiveau niveau,

        LocalTime duree,

        String description

) {
}
