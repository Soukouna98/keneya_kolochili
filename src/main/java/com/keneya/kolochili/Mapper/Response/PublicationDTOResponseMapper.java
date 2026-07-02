package com.keneya.kolochili.Mapper.Response;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.PublicationDTOResponse;
import com.keneya.kolochili.MODEL.Publication;

@Component
public class PublicationDTOResponseMapper
        implements Function<Publication, PublicationDTOResponse> {

    @Override
    public PublicationDTOResponse apply(Publication p) {

        if (p == null) return null;

        return new PublicationDTOResponse(

                p.getId(),
                p.getAgent() != null ? p.getAgent().getId() : null,
                p.getNomMaladie(),
                p.getSymptome(),
                p.getConseilPreventif(),
                p.getSources(),
                p.isArchive(),
                p.getDateCreation()
                 

        );
    }
}
