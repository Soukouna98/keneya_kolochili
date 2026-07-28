package com.keneya.kolochili.Service.Activite;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.DTO.Request.Activite.ActiviteRealiseeDTORequest;
import com.keneya.kolochili.DTO.Response.Activite.ActiviteRealiseeDTOResponse;
import com.keneya.kolochili.IService.Activite.IServiceActiviteRealisee;
import com.keneya.kolochili.MODEL.ActiviteRealisee;
import com.keneya.kolochili.MODEL.CitoyenActivitePlan;
import com.keneya.kolochili.Mapper.Request.Activite.ActiviteRealiseeDTORequestMapper;
import com.keneya.kolochili.Mapper.Response.Activite.ActiviteRealiseeDTOResponseMappper;
import com.keneya.kolochili.Repository.ActiviteRealiseeRepository;
import com.keneya.kolochili.Repository.CitoyenActivitePlanRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActiviteRealiseeService implements IServiceActiviteRealisee {

    private final ActiviteRealiseeRepository activiteRealiseeRepository;
    private final CitoyenActivitePlanRepository citoyenActivitePlanRepository;
    private final ActiviteRealiseeDTORequestMapper activiteRealiseeDTORequestMapper;
    private final ActiviteRealiseeDTOResponseMappper activiteRealiseeDTOResponseMappper;

    @Override
    public void creer(ActiviteRealiseeDTORequest entity) {
        ActiviteRealisee activiteRealisee = activiteRealiseeDTORequestMapper.apply(entity);
        activiteRealiseeRepository.save(activiteRealisee);
    }

    @Override
    public void modifier(ActiviteRealiseeDTORequest entity, Long id) {
        ActiviteRealisee activiteRealisee = activiteRealiseeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActiviteRealisee non trouvee avec l'id: " + id));
        
        CitoyenActivitePlan plan = citoyenActivitePlanRepository.findById(entity.idCitoyenActivitePlan())
                .orElseThrow(() -> new EntityNotFoundException("CitoyenActivitePlan non trouve avec l'id: " + entity.idCitoyenActivitePlan()));
        
        activiteRealisee.setCitoyenActivitePlan(plan);
        activiteRealisee.setFrequence(entity.frequence());
        
        activiteRealiseeRepository.save(activiteRealisee);
    }

    @Override
    public void supprimer(Long id) {
        if (!activiteRealiseeRepository.existsById(id)) {
            throw new EntityNotFoundException("ActiviteRealisee non trouvee avec l'id: " + id);
        }
        activiteRealiseeRepository.deleteById(id);
    }

    @Override
    public ActiviteRealiseeDTOResponse findById(Long id) {
        ActiviteRealisee activiteRealisee = activiteRealiseeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActiviteRealisee non trouvee avec l'id: " + id));
        return activiteRealiseeDTOResponseMappper.apply(activiteRealisee);
    }

    @Override
    public List<ActiviteRealiseeDTOResponse> getAll() {
        List<ActiviteRealisee> list = activiteRealiseeRepository.findAll();
        return list.stream()
                .map(activiteRealiseeDTOResponseMappper::apply)
                .toList();
    }
}
