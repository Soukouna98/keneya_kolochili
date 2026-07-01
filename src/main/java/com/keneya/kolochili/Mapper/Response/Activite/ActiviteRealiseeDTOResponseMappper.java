package com.keneya.kolochili.Mapper.Response.Activite;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.Activite.ActiviteRealiseeDTOResponse;
import com.keneya.kolochili.MODEL.ActiviteRealisee;

@Component
public class ActiviteRealiseeDTOResponseMappper implements Function<ActiviteRealisee, ActiviteRealiseeDTOResponse> {

    @Override
    public ActiviteRealiseeDTOResponse apply(ActiviteRealisee t) {
        return new ActiviteRealiseeDTOResponse(
                t.getIdActiviteRealisee(),
                t.getCitoyenActivitePlan() != null ? t.getCitoyenActivitePlan().getIdCitoyenActivitePlan() : null,
                t.getFrequence(),
                t.getDate()
        );
    }
}
