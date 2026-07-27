package com.keneya.kolochili.IService.rappel;

import java.util.List;

import com.keneya.kolochili.MODEL.Rappel;
import com.keneya.kolochili.DTO.Request.RappelDTO;

public interface Irappel {

    Rappel creeRappel (RappelDTO rappel);
    List<Rappel> read();
    Rappel   updateRappel(Long id, Rappel rappel);
    String deleteRappel(Long id);
    List<Rappel> ListeRappelActiveById();
    void verifierRappels();
	List<Rappel> getRappelsActifs();
    List<Rappel> getRappelsTerminer();
    void  TraiterTousRappelsDus();

	

}
