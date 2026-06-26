package com.keneya.kolochili.Mapper.Response;


import java.util.function.Function;
import org.springframework.stereotype.Component;
import com.keneya.kolochili.DTO.Response.CategorieConseilDTOResponse;
import com.keneya.kolochili.MODEL.CategorieConseil;

@Component
public class CategorieConseilDTOResponseMapper implements Function<CategorieConseil, CategorieConseilDTOResponse> {

    @Override
    public CategorieConseilDTOResponse apply(CategorieConseil t) {
        if (t == null) return null;

        return new CategorieConseilDTOResponse(
                t.getId(),
                t.getNom(),
                t.getDescription(),
                t.isArchive(),
                t.getAdmin() != null ? t.getAdmin().getId() : null 
        );
    }
}
