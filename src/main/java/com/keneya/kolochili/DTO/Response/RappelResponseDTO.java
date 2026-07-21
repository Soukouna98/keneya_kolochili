package com.keneya.kolochili.DTO.Response;

import com.keneya.kolochili.Enumeration.TypeFrequence;
import com.keneya.kolochili.MODEL.Rappel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RappelResponseDTO {
    private final Long id;
    private final String nom_medicament;
    private final TypeFrequence frequence;
    private final Integer intervalle;
    private final LocalDateTime dateDebut;
    private final LocalDateTime dateFin;
    private final LocalDateTime dateRappel;
    private final LocalDateTime dateCreation;
    private final Boolean archive;

    public  RappelResponseDTO(Rappel r){
        this.id = r.getId();
        this.nom_medicament = r.getNom_medicament();
        this.frequence = r.getFrequence();
        this.intervalle = r.getIntervalle();
        this.dateDebut = r.getDateDebut();
        this.dateFin = r.getDateFin();
        this.dateRappel = r.getDateRappel();
        this.dateCreation = r.getDateCreation();
        this.archive = r.isArchive();

    }

}
