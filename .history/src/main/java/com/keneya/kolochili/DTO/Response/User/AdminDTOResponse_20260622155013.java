package c:\Users\amado\OneDrive\Desktop\ODK\Groupe2\keneya\src\main\java\aon\pheno\keneya\DTO\Response\User

import java.time.LocalDateTime;

public record AdminDTOResponse(
        Long id,
        String nom,
        String prenom,
        String email,
        String telephone,
        boolean archive,
        LocalDateTime dateCreation
        ) {}