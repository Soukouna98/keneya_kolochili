package com.keneya.kolochili.Mapper.Response.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;


@Component
public class AdminDTOResponseMappper implements Function<Admin,AdminDTOResponse> {

    @Override
    public AdminDTOResponse apply(Admin t) {
        return new AdminDTOResponse(t.getId(),t.getNom(),t.getPrenom(),t.getEmail(),t.getPhone(),t.isArchive(),t.getDateCreation());
    }
}
