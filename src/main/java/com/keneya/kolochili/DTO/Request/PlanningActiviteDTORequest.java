package com.keneya.kolochili.DTO.Request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlanningActiviteDTORequest (

    @NotBlank(message = "Le jour est obligatoire")
    String jour,

    @NotNull(message = "L'heure est obligatoire")
    LocalTime heure
){}