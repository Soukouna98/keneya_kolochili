package com.keneya.kolochili.DTO.Request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CitoyenActivitePlanDTORequest ( 

    @NotNull(message = "L'identifiant du citoyen est obligatoire")
    Long idCitoyen,

    @NotNull(message = "L'identifiant de l'activité est obligatoire")
    Long idActivite,

    @NotEmpty(message = "Au moins un planning doit être renseigné")
    List<PlanningActiviteDTORequest> plannings
) {}