package com.keneya.kolochili.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Request.User.ActivitesDTORequest;
import com.keneya.kolochili.DTO.Response.User.ActivitesDTOResponse;
import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.Exception.ForbiddenException;
import com.keneya.kolochili.IService.User.IServiceActivite;
import com.keneya.kolochili.MODEL.Activites;
import com.keneya.kolochili.MODEL.Agent;
import com.keneya.kolochili.MODEL.CategorieActivite;
import com.keneya.kolochili.Mapper.Request.ActivitesDTORequestMapper;
import com.keneya.kolochili.Mapper.Response.User.ActivitesDTOResponseMapper;
import com.keneya.kolochili.Repository.ActivitesRepository;
import com.keneya.kolochili.Repository.AgentRepository;
import com.keneya.kolochili.Repository.CategorieActiviteRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivitesService implements IServiceActivite {

    private final ActivitesRepository activitesRepository;
    private final AgentRepository agentRepository;
    private final CategorieActiviteRepository categorieRepository;

    private final ActivitesDTORequestMapper requestMapper;
    private final ActivitesDTOResponseMapper responseMapper;

    // CREATE
    @Override
    public void creer(ActivitesDTORequest entity) {

        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())
                && !TypeRole.AGENT.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas le droit de créer une activité");
        }

        Agent agent = agentRepository.findById(entity.idAgent())
                .orElseThrow(() -> new EntityNotFoundException("Agent non trouvé"));

        CategorieActivite categorie = categorieRepository.findById(entity.idCategorieActivite())
                .orElseThrow(() -> new EntityNotFoundException("Catégorie non trouvée"));

        Activites activite = requestMapper.apply(entity);
        activite.setAgent(agent);
        activite.setCategorieActivite(categorie);

        activitesRepository.save(activite);
    }

    // UPDATE
    @Override
    public void modifier(ActivitesDTORequest entity, Long id) {

        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())
                && !TypeRole.AGENT.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas le droit de modifier une activité");
        }

        Activites activite = activitesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activité non trouvée"));

        Agent agent = agentRepository.findById(entity.idAgent())
                .orElseThrow(() -> new EntityNotFoundException("Agent non trouvé"));

        CategorieActivite categorie = categorieRepository.findById(entity.idCategorieActivite())
                .orElseThrow(() -> new EntityNotFoundException("Catégorie non trouvée"));

        activite.setAgent(agent);
        activite.setCategorieActivite(categorie);
        activite.setDate(entity.date());
        activite.setNom(entity.nom());
        activite.setNiveau(entity.niveau());
        activite.setDuree(entity.duree());
        activite.setDescription(entity.description());

        activitesRepository.save(activite);
    }

    // DELETE
    @Override
    public void supprimer(Long id) {

        if (!TypeRole.ADMIN.equals(CurrentUserContext.get().getRole().getName())) {
            throw new ForbiddenException("Vous n'avez pas le droit de supprimer une activité");
        }

        Activites activite = activitesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activité non trouvée"));

        activitesRepository.delete(activite);
    }

    // GET BY ID
    @Override
    public ActivitesDTOResponse findById(Long id) {

        Activites activite = activitesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activité non trouvée"));

        return responseMapper.apply(activite);
    }

    // GET ALL
    @Override
    public List<ActivitesDTOResponse> getAll() {

        List<Activites> activites = activitesRepository.findAll();
        
        return activites.stream()
                .map(responseMapper)
                .toList();
    }
}