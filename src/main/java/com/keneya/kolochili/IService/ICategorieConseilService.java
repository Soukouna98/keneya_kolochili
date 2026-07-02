package com.keneya.kolochili.IService;

import java.util.List;

import com.keneya.kolochili.DTO.Request.CategorieConseilDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieConseilDTOResponse;

public interface ICategorieConseilService {
    void creer(CategorieConseilDTORequest request);
    void modifier(CategorieConseilDTORequest request, Long id);
    void supprimer(Long id);
    CategorieConseilDTOResponse findById(Long id);
    List<CategorieConseilDTOResponse> getAll();
}
