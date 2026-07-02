package com.keneya.kolochili.DTO.Response;

import java.util.List;

public record CitoyenActivitePlanDTOResponse ( 

    Long idCitoyenActivitePlan,

    String nomCitoyen,

    Long idActivite,

    String nomActivite,

    List<PlanningActiviteDTOResponse> plannings
    
) {}
