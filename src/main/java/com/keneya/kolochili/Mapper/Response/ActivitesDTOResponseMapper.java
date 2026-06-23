package com.keneya.kolochili.Mapper.Response.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.User.ActivitesDTOResponse;
import com.keneya.kolochili.MODEL.Activites;

@Component
public class ActivitesDTOResponseMapper
        implements Function<Activites, ActivitesDTOResponse> {

    @Override
    public ActivitesDTOResponse apply(Activites t) {

        return new ActivitesDTOResponse(
                t.getIdActivites(),
                t.getAgent().getNom(),
                t.getAgent().getPrenom(),
                t.getCategorieActivite().getNom(),
                t.getDate(),
                t.getNom(),
                t.getNiveau(),
                t.getDuree(),
                t.getDescription()
        );
    }
}
