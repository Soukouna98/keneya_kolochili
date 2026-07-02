package com.keneya.kolochili.DTO.Response;

import java.time.LocalDateTime;

public record ActiviteRealiseeDTOResponse(
        Long idActiviteRealisee,
        Long idCitoyenActivitePlan,
        String frequence,
        LocalDateTime date
) {
}
