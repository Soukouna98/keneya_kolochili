package com.keneya.kolochili.Mapper;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.PublicationDTO;
import com.keneya.kolochili.MODEL.Publication;

@Component
public class PublicationMapper {

    public PublicationDTO toDTO(Publication p) {

        PublicationDTO dto = new PublicationDTO();

        dto.setId(p.getId());
        dto.setNomMaladie(p.getNomMaladie());
        dto.setSymptome(p.getSymptome());
        dto.setConseilPreventif(p.getConseilPreventif());
        dto.setSources(p.getSources());
        dto.setArchive(p.isArchive());

        if (p.getAgent() != null) {
            dto.setAgentId(p.getAgent().getId());
        }

        return dto;
    }

    public Publication toEntity(PublicationDTO dto) {

        Publication p = new Publication();

        p.setNomMaladie(dto.getNomMaladie());
        p.setSymptome(dto.getSymptome());
        p.setConseilPreventif(dto.getConseilPreventif());
        p.setSources(dto.getSources());
        p.setArchive(dto.isArchive());

        return p;
    }
}