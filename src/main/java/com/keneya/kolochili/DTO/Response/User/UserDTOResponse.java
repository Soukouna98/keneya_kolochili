package com.keneya.kolochili.DTO.Response.User;

import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.MODEL.Utilisateur;

public record UserDTOResponse(    Long id,
                                  String nom,
                                  String prenom,
                                  String email,
                                  String phone,
                                  TypeRole role
) {
    public static UserDTOResponse fromEntity(Utilisateur user) {
        return new UserDTOResponse(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getEmail(),
                user.getPhone(),
                user.getRole().getName()
        );
    }
}
