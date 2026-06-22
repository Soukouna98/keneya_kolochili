package com.keneya.kolochili.Mapper.Response.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.keneya.kolochili.DTO.Response.User.AdminDTOResponse;
import com.keneya.kolochili.MODEL.Admin;


@Component
public class AdminDTOResponseMappper implements Function<Admin,AdminDTOResponse> {

    @Override
    public AdminDTOResponse apply(Admin t) {
        return new AdminDTOResponse(t.getId(),t.getNom(),t.getPrenom(),t.getEmail(),t.getPhone(),t.isArchive(),t.da());
    }
}
