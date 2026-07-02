package com.keneya.kolochili.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieActiviteDTOResponse {
    
    private Long id;
    private String libelle;
    private String description;
    private boolean archive;
}
