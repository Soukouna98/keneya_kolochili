package com.keneya.kolochili.IService;

import java.util.List;
import com.keneya.kolochili.DTO.Request.PublicationDTORequest;
import com.keneya.kolochili.DTO.Response.PublicationDTOResponse;

 

public interface IServicePublication {
   
   
    void creer(PublicationDTORequest request);

    void modifier(PublicationDTORequest request, Long id);

    void supprimer(Long id);

    PublicationDTOResponse findById(Long id);

    List<PublicationDTOResponse> getAll();

    List<PublicationDTOResponse> getArchives();


     

     
}
