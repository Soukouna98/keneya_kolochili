package com.keneya.kolochili.DTO.Response;

import java.time.LocalDateTime;

public record PublicationDTOResponse(
       Long id,
        String nomMaladie,
        String symptome,
        String conseilPreventif,
        String source,
        boolean archive,
        LocalDateTime dateCreation
) {


}
