package com.keneya.kolochili.Mapper.Request.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Request.User.CitoyenDTORequest;
import com.keneya.kolochili.MODEL.Citoyen;


@Component
public class CitoyenDTORequestMapper implements Function<CitoyenDTORequest, Citoyen>{

    @Override
    public Citoyen apply(CitoyenDTORequest t) {
        Citoyen citoyen = new Citoyen();
        citoyen.setNom(t.nom());
        citoyen.setPrenom(t.prenom());
        citoyen.setEmail(t.email());
        citoyen.setMdp(t.password());
        citoyen.setPhone(t.telephone());
        citoyen.setDate_naissance(t.date_naissance());
        return citoyen;
    }
}
