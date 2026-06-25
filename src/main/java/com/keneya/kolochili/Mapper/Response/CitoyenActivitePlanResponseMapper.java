package com.keneya.kolochili.Mapper.Response;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.CitoyenActivitePlanDTOResponse;
import com.keneya.kolochili.MODEL.CitoyenActivitePlan;

@Component
public class CitoyenActivitePlanResponseMapper {

    private final PlanningActiviteResponseMapper planningMapper;

    public CitoyenActivitePlanResponseMapper(PlanningActiviteResponseMapper planningMapper) {
        this.planningMapper = planningMapper;
    }

    public CitoyenActivitePlanDTOResponse apply(CitoyenActivitePlan plan) {
        return new CitoyenActivitePlanDTOResponse(
            plan.getIdCitoyenActivitePlan(),            
            plan.getCitoyen().getNom(),                  
            plan.getActivite().getIdActivites(),          
            plan.getActivite().getNom(),                  
            plan.getPlannings()                          
                .stream()
                .map(planningMapper) 
                .collect(Collectors.toList())
        );
    }
}
