package com.keneya.kolochili.Mapper.Request;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.CitoyenActivitePlanDTORequest;
import com.keneya.kolochili.MODEL.CitoyenActivitePlan;

@Component
public class CitoyenActivitePlanRequestMapper {

    private final PlanningActiviteRequestMapper planningMapper;

    public CitoyenActivitePlanRequestMapper(
            PlanningActiviteRequestMapper planningMapper) {

        this.planningMapper = planningMapper;
    }

    public CitoyenActivitePlan apply(
            CitoyenActivitePlanDTORequest dto) {

        CitoyenActivitePlan plan =
                new CitoyenActivitePlan();

        plan.setPlannings(
                dto.plannings()
                        .stream()
                        .map(planningMapper)
                        .collect(Collectors.toList()));

        return plan;
    }
}