package com.keneya.kolochili.Mapper.Response;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.PlanningActiviteDTOResponse;
import com.keneya.kolochili.MODEL.PlanningActivite;

@Component
public class PlanningActiviteResponseMapper
        implements Function<PlanningActivite, PlanningActiviteDTOResponse> {

    @Override
    public PlanningActiviteDTOResponse apply(
            PlanningActivite planning) {

                return new PlanningActiviteDTOResponse( 
       
                planning.getIdPlanning(),

                planning.getJour(),

                planning.getHeure()
        );
    }
}