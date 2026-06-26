package com.keneya.kolochili.Mapper.Request;


import java.util.function.Function;
import org.springframework.stereotype.Component;
import com.keneya.kolochili.DTO.Request.CategorieConseilDTORequest;
import com.keneya.kolochili.MODEL.CategorieConseil;

@Component
public class CategorieConseilDTORequestMapper implements Function<CategorieConseilDTORequest, CategorieConseil> {

    @Override
    public CategorieConseil apply(CategorieConseilDTORequest t) {
        if (t == null) return null;

        CategorieConseil categorie = new CategorieConseil();
        categorie.setNom(t.nom());
        categorie.setDescription(t.description());
        categorie.setArchive(false); // Non archivé par défaut
        return categorie;
    }
}