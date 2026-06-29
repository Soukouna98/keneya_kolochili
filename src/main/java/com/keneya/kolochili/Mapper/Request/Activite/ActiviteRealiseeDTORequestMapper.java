package com.keneya.kolochili.Mapper.Request.Activite;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.Activite.ActiviteRealiseeDTORequest;
import com.keneya.kolochili.MODEL.ActiviteRealisee;
import com.keneya.kolochili.MODEL.CitoyenActivitePlan;
import com.keneya.kolochili.Repository.CitoyenActivitePlanRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActiviteRealiseeDTORequestMapper implements Function<ActiviteRealiseeDTORequest, ActiviteRealisee> {

    private final CitoyenActivitePlanRepository citoyenActivitePlanRepository;

    @Override
    public ActiviteRealisee apply(ActiviteRealiseeDTORequest t) {
        ActiviteRealisee activiteRealisee = new ActiviteRealisee();
        activiteRealisee.setFrequence(t.frequence());
        
        CitoyenActivitePlan plan = citoyenActivitePlanRepository.findById(t.idCitoyenActivitePlan())
                .orElseThrow(() -> new EntityNotFoundException("CitoyenActivitePlan non trouve avec l'id: " + t.idCitoyenActivitePlan()));
        activiteRealisee.setCitoyenActivitePlan(plan);
        
        return activiteRealisee;
    }
}
