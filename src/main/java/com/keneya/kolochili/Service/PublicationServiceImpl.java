package com.keneya.kolochili.Service;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
 
import com.keneya.kolochili.DTO.Request.PublicationDTORequest;
import com.keneya.kolochili.DTO.Response.PublicationDTOResponse;
import com.keneya.kolochili.IService.IServicePublication;

import com.keneya.kolochili.MODEL.Agent;
 
import com.keneya.kolochili.MODEL.Publication;
import com.keneya.kolochili.MODEL.Utilisateur;

import com.keneya.kolochili.Repository.AgentRepository;
import com.keneya.kolochili.Repository.PublicationRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements IServicePublication {

    private final PublicationRepository repository;
    private final AgentRepository agentRepository;

    private final Function<PublicationDTORequest, Publication> requestMapper;
    private final Function<Publication, PublicationDTOResponse> responseMapper;

    @Override
    public void creer(PublicationDTORequest request) {

       Utilisateur user = CurrentUserContext.get();
                Agent agent = agentRepository.findById(user.getId())
                                .orElseThrow(() -> new EntityNotFoundException("L'agent introuvable"));
                Publication publication = new Publication();

        Publication p = requestMapper.apply(request);
        p.setAgent(agent);

        repository.save(p);
    }

    @Override
    public void modifier(PublicationDTORequest request, Long id) {

        Publication p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication introuvable"));

        p.setNomMaladie(request.nomMaladie());
        p.setSymptome(request.symptome());
        p.setConseilPreventif(request.conseilPreventif());
        p.setSources(request.source());

        repository.save(p);
    }

    @Override
    public void supprimer(Long id) {

        Publication p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication introuvable"));

        p.setArchive(true);

        repository.save(p);
    }

    @Override
    public PublicationDTOResponse findById(Long id) {

        return repository.findById(id)
                .map(responseMapper)
                .orElseThrow(() -> new RuntimeException("Publication introuvable"));
    }

    @Override
    public List<PublicationDTOResponse> getAll() {

        return repository.findByArchiveFalse()
                .stream()
                .map(responseMapper)
                .toList();
    }

    @Override
    public List<PublicationDTOResponse> getArchives() {

        return repository.findByArchiveTrue()
                .stream()
                .map(responseMapper)
                .toList();
    }
}
 

 