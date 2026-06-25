package com.keneya.kolochili.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.DTO.PublicationDTO;
import com.keneya.kolochili.IService.IServicePublication;
import com.keneya.kolochili.MODEL.Agent;
import com.keneya.kolochili.MODEL.Publication;
import com.keneya.kolochili.Mapper.PublicationMapper;
import com.keneya.kolochili.Repository.AgentRepository;
import com.keneya.kolochili.Repository.PublicationRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements IServicePublication {

    private final PublicationRepository publicationRepository;
    private final AgentRepository agentRepository;
    private final PublicationMapper mapper;

    @Override
    public PublicationDTO create(PublicationDTO dto) {

        Agent agent = agentRepository.findById(dto.getAgentId())
                .orElseThrow(() -> new RuntimeException("Publication introuvable"));

        Publication p = mapper.toEntity(dto); // ici on appelé le Mappeur 
        p.setAgent(agent);

        return mapper.toDTO(publicationRepository.save(p));
    }
     @Override
      public PublicationDTO getById(Long id) {

        Publication p = publicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publication introuvable"));

        return mapper.toDTO(p);
    }

   
    
    @Override
     public List<PublicationDTO> getAll() {
        // return publicationRepository.findAll()
        //         .stream()
        //         .map(mapper::toDTO)
        //         .toList();
         return publicationRepository.findByArchiveFalse()
            .stream()
            .map(mapper::toDTO)
            .toList();
    }

    @Override
     public PublicationDTO update(Long id, PublicationDTO dto) {

        Publication p = publicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publication introuvable"));

        p.setNomMaladie(dto.getNomMaladie());
        p.setSymptome(dto.getSymptome());
        p.setConseilPreventif(dto.getConseilPreventif());
        p.setSources(dto.getSources());
        p.setArchive(dto.isArchive());

        return mapper.toDTO(publicationRepository.save(p));
    }

     //Suppression de publication
     public void delete(Long id) {
        publicationRepository.deleteById(id);
    }
    //Partie archive
    @Override
    public PublicationDTO archiver(Long id) {

    Publication publication = publicationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Publication introuvable"));

    publication.setArchive(true);

    Publication saved = publicationRepository.save(publication);

    return mapper.toDTO(saved);
}

//Partie desarchive
@Override
public PublicationDTO desarchiver(Long id) {

    Publication publication = publicationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Publication introuvable"));

    publication.setArchive(false);

    Publication saved = publicationRepository.save(publication);

    return mapper.toDTO(saved);
}
// La methode pour recuperer les publications archivées
public List<PublicationDTO> getArchives() {

    return publicationRepository.findByArchiveTrue()
            .stream()
            .map(mapper::toDTO)
            .toList();
}

     
     
}

 