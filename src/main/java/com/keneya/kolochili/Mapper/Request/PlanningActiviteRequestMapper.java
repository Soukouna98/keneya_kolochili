package com.keneya.kolochili.Mapper.Request;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.PlanningActiviteDTORequest;
import com.keneya.kolochili.MODEL.PlanningActivite;

@Component
public class PlanningActiviteRequestMapper
        implements Function<PlanningActiviteDTORequest, PlanningActivite> {

    @Override
    public PlanningActivite apply(PlanningActiviteDTORequest dto) {

        PlanningActivite planning = new PlanningActivite();

        planning.setJour(dto.jour());
        planning.setHeure(dto.heure());

        return planning;
    }
}