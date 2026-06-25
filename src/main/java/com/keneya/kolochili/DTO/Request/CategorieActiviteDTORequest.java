package com.keneya.kolochili.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategorieActiviteDTORequest {
    
    @NotBlank(message = "Le libellé est obligatoire")
    private String libelle;
    
    private String description;
}
