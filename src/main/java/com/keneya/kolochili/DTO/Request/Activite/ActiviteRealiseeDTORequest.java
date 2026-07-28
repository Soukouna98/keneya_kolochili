package com.keneya.kolochili.DTO.Request.Activite;

import jakarta.validation.constraints.NotNull;

public record ActiviteRealiseeDTORequest(
        @NotNull(message = "L'identifiant du plan d'activite citoyen est obligatoire")
        Long idCitoyenActivitePlan,
        
        String frequence
) {
}
