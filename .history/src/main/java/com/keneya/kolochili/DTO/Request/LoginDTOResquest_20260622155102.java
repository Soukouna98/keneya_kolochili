package com.keneya.kolochili.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTOResquest(
    @Email(message="Email incorrect ou vide")
    String email,
    @NotBlank(message="Le mot de passe est obligatoire")
    String password) {}
