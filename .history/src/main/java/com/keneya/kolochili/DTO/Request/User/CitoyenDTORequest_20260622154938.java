package com.keneya.kolochili.DTO.Request.User;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CitoyenDTORequest(
        @NotBlank(message = "Nom du citoyen est obligatoire")
        String nom,
        @NotBlank(message = "Prenom du citoyen  est obligatoire")
        String prenom,
        @Email(message = "Email du citoyen  est obligatoire")
        String email,
        @NotBlank(message = "Mot de passe du citoyen est obligatoire")
        String password,
        String telephone,
        LocalDateTime date_naissance
        ) {

}
