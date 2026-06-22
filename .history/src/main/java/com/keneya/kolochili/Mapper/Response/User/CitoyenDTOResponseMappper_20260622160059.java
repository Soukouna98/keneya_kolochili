package com.keneya.kolochili.Mapper.Response.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.MODEL.Citoyen;



@Component
public class CitoyenDTOResponseMappper implements Function<Citoyen,CitoyenDTOResponse> {

    @Override
    public CitoyenDTOResponse apply(Citoyen t) {
        return new CitoyenDTOResponse(t.getId(),t.getNom(),t.getPrenom(),t.getEmail(),t.getPhone(),t.getDate_naissance(),t.isArchive(),t.getDateCreation());
    }
}
