package com.keneya.kolochili.DTO.Response;

import com.keneya.kolochili.Enumeration.TypeFrequence;
import com.keneya.kolochili.MODEL.Rappel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public record RappelResponseDTO(

        Long id,
        String nom_medicament,
        TypeFrequence frequence,
        Integer intervalle,
        LocalDateTime dateDebut,
        LocalDateTime dateFin,
        LocalDateTime dateRappel,
        LocalDateTime dateCreation,
        Boolean archive,
        Boolean terminer
) {

    public static RappelResponseDTO fromEntity  (Rappel r){
        return  new RappelResponseDTO(
                r.getId(),
               r.getNom_medicament(),
              r.getFrequence(),
              r.getIntervalle(),
              r.getDateDebut(),
              r.getDateFin(),
             r.getDateRappel(),
             r.getDateCreation(),
              r.isArchive(),
            r.isTerminer()
        );


    }

}
