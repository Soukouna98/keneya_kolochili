package com.keneya.kolochili.Mapper.Request;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.CitoyenActivitePlanDTORequest;
import com.keneya.kolochili.MODEL.CitoyenActivitePlan;

@Component
public class CitoyenActivitePlanRequestMapper
        implements Function<CitoyenActivitePlanDTORequest, CitoyenActivitePlan> {

    @Override
    public CitoyenActivitePlan apply(
            CitoyenActivitePlanDTORequest dto) {

        CitoyenActivitePlan plan =
                new CitoyenActivitePlan();

        return plan;
    }
}