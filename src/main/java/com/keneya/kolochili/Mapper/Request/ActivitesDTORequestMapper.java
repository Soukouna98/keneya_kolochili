package com.keneya.kolochili.Mapper.Request;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.User.ActivitesDTORequest;
import com.keneya.kolochili.MODEL.Activites;

@Component
public class ActivitesDTORequestMapper
        implements Function<ActivitesDTORequest, Activites> {

    @Override
    public Activites apply(ActivitesDTORequest t) {

        Activites activites = new Activites();

        activites.setDate(t.date());
        activites.setNom(t.nom());
        activites.setNiveau(t.niveau());
        activites.setDuree(t.duree());
        activites.setDescription(t.description());

        return activites;
    }
}