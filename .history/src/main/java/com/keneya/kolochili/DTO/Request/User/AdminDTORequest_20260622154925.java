package ;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminDTORequest(
        @NotBlank(message = "Nom de l'admin est obligatoire")
        String nom,
        @NotBlank(message = "Prenom de l'admin est obligatoire")
        String prenom,
        @Email(message = "Email de l'admin est obligatoire")
        String email,
        @NotBlank(message = "Mot de passe de l'admin est obligatoire")
        String password,
        String telephone
        ) {}
