package com.keneya.kolochili.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record request( 
    @NotNull(message = "L'identifient du citoyen est ogligatoire ")
    Long idCitoyen,

    @NotNull(message = "L'identifient de l'activité est obligatoire")
    Long idActivite,

    @NotBlank(message = "La fréquence est obligatoire")
    String frequence) {}
