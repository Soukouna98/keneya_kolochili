package com.keneya.kolochili.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.DTO.Request.CitoyenActivitePlanDTORequest;
import com.keneya.kolochili.DTO.Response.CitoyenActivitePlanDTOResponse;
import com.keneya.kolochili.Exception.ResourceNotFoundException;
import com.keneya.kolochili.IService.ICitoyenActivitePlanService;
import com.keneya.kolochili.MODEL.Activites;
import com.keneya.kolochili.MODEL.Citoyen;
import com.keneya.kolochili.MODEL.CitoyenActivitePlan;
import com.keneya.kolochili.MODEL.PlanningActivite;
import com.keneya.kolochili.Mapper.Request.CitoyenActivitePlanRequestMapper;
import com.keneya.kolochili.Mapper.Response.CitoyenActivitePlanResponseMapper;
import com.keneya.kolochili.Repository.ActivitesRepository;
import com.keneya.kolochili.Repository.CitoyenActivitePlanRepository;
import com.keneya.kolochili.Repository.CitoyenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitoyenActivitePlanService
        implements ICitoyenActivitePlanService {

    private final CitoyenRepository citoyenRepository;

    private final ActivitesRepository activitesRepository;

    private final CitoyenActivitePlanRepository planRepository;

    private final CitoyenActivitePlanRequestMapper requestMapper;

    private final CitoyenActivitePlanResponseMapper responseMapper;

    @Override
    public CitoyenActivitePlanDTOResponse create(
            CitoyenActivitePlanDTORequest dto) {

        Citoyen citoyen =
                citoyenRepository.findById(dto.idCitoyen())
                        .orElseThrow(() ->
                 new ResourceNotFoundException(
                "Citoyen introuvable"));
        Activites activite =
                activitesRepository.findById(dto.idActivite())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Activité introuvable"));

        CitoyenActivitePlan plan =
                requestMapper.apply(dto);

                plan.getPlannings()
                .forEach(planning ->
                planning.setCitoyenActivitePlan(plan));

        plan.setCitoyen(citoyen);
        plan.setActivite(activite);

        CitoyenActivitePlan savedPlan =
                planRepository.save(plan);

        return responseMapper.apply(savedPlan);
    }

    @Override
    public CitoyenActivitePlanDTOResponse getById(Long id) {

        CitoyenActivitePlan plan =
                planRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Plan introuvable"));

        return responseMapper.apply(plan);
    }

    @Override
    public List<CitoyenActivitePlanDTOResponse> getAll() {

        return planRepository.findAll()
                .stream()
                .map(responseMapper::apply)
                .toList();
    }

    @Override
    public void delete(Long id) {

        CitoyenActivitePlan plan =
                planRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Plan introuvable"));

        planRepository.delete(plan);
    }

   @Override
        public CitoyenActivitePlanDTOResponse update(
        Long id,
        CitoyenActivitePlanDTORequest dto) {

    CitoyenActivitePlan plan =
            planRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Plan introuvable"));

    Citoyen citoyen =
            citoyenRepository.findById(dto.idCitoyen())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Citoyen introuvable"));

    Activites activite =
            activitesRepository.findById(dto.idActivite())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Activité introuvable"));

    plan.setCitoyen(citoyen);
    plan.setActivite(activite);

    plan.getPlannings().clear();

    dto.plannings().forEach(p -> {

        PlanningActivite planning =
                new PlanningActivite();

        planning.setJour(p.jour());
        planning.setHeure(p.heure());

        planning.setCitoyenActivitePlan(plan);

        plan.getPlannings().add(planning);
    });

    CitoyenActivitePlan updatedPlan =
            planRepository.save(plan);

    return responseMapper.apply(updatedPlan);
}
}