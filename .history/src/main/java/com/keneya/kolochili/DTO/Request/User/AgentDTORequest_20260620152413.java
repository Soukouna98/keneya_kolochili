package aon.pheno.keneya.DTO.Request.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AgentDTORequest(
        @NotBlank(message = "Nom de l'agent est obligatoire")
        String nom,
        @NotBlank(message = "Prenom de l'agent est obligatoire")
        String prenom,
        @Email(message = "Email de l'agent est obligatoire")
        String email,
        @NotBlank(message = "Mot de passe de l'agent est obligatoire")
        String password,
        String telephone,
        @NotBlank(message = "La specialite de l'agent est obligatoire")
        String specialite
        ) {}
