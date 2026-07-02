package com.keneya.kolochili.Mapper.Request;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.PublicationDTORequest;
import com.keneya.kolochili.MODEL.Publication;

@Component
public class PublicationDTORequestMapper
        implements Function<PublicationDTORequest, Publication> {

    @Override
    public Publication apply(PublicationDTORequest request) {

        if (request == null) return null;

        Publication p = new Publication();

        p.setNomMaladie(request.nomMaladie());
        p.setSymptome(request.symptome());
        p.setConseilPreventif(request.conseilPreventif());
        p.setSources(request.source());
        p.setArchive(false);

        return p;
    }
}