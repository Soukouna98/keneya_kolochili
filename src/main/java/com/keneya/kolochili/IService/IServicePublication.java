package com.keneya.kolochili.IService;

import java.util.List;

 

import com.keneya.kolochili.DTO.PublicationDTO;

 

public interface IServicePublication {
   
    //Ici c'est le DTO qui transfert les données au lieu de Model 
    //Les mdethodes 
    PublicationDTO create(PublicationDTO dto);

    PublicationDTO getById(Long id);

    List<PublicationDTO> getAll();

    PublicationDTO update(Long id, PublicationDTO dto);

    void delete(Long id);
    //Les informations de l'archive et desarche
    PublicationDTO archiver(Long id);
    PublicationDTO desarchiver(Long id);
    List<PublicationDTO> getArchives();

     

     
}
