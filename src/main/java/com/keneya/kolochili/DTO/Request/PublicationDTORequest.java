package com.keneya.kolochili.DTO.Request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record PublicationDTORequest(
        @NotBlank(message = "Nom de la maladie est obligatoire")
        String nomMaladie,
        @NotBlank(message = "Les symptômes sont obligatoires")
        String symptome,
        @NotBlank(message = "Le conseil  est obligatoire")
        String conseilPreventif,
        @NotBlank(message = "La source est obligatoire")
        String source,
        Boolean archive,
        LocalDateTime dateCreation
    ) 
    
        {

     
}
