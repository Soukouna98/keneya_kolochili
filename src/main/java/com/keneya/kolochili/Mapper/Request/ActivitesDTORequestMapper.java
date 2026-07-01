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

    Activites a = new Activites();

    a.setDate(t.date());
    a.setNom(t.nom());
    a.setNiveau(t.niveau());
    a.setDuree(t.duree());
    a.setDescription(t.description());

    return a;
    }
}