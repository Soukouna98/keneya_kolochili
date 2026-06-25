package com.keneya.kolochili.DTO.Response;

import java.time.LocalTime;

public record  PlanningActiviteDTOResponse (

    Long idPlanning,

    String jour,

    LocalTime heure

) {}
    

