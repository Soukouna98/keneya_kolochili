package com.keneya.kolochili.IService.User;

import java.util.List;

import com.keneya.kolochili.DTO.Request.User.ActivitesDTORequest;
import com.keneya.kolochili.DTO.Response.User.ActivitesDTOResponse;



public interface IServiceActivite {

    void creer(ActivitesDTORequest entity);

    void modifier(ActivitesDTORequest entity, Long id);

    void supprimer(Long id);

    ActivitesDTOResponse findById(Long id);

    List<ActivitesDTOResponse> getAll();
}