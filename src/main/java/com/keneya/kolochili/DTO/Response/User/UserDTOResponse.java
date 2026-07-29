package com.keneya.kolochili.DTO.Response.User;

import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.MODEL.Utilisateur;

public record UserDTOResponse(
        Long id,
        String nom,
        String prenom,
        String email,
        String phone,
        String role  // Changé en String
) {
    public static UserDTOResponse fromEntity(Utilisateur user) {
        return new UserDTOResponse(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getEmail(),
                user.getPhone(),
                user.getRole().getName().name()  // Si getName() retourne un TypeRole
                // OU
                // user.getRole().getName()  // Si getName() retourne un String
        );
    }
}