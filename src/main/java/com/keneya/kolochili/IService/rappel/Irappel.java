package com.keneya.kolochili.IService.rappel;

import java.util.List;

import com.keneya.kolochili.MODEL.Rappel;

public interface Irappel {

    Rappel creeRappel (Rappel rappel);
    List<Rappel> read();
    Rappel   updateRappel(Long id, Rappel rappel);
    String deleteRappel(Long id);
    List<Rappel> ListeRappelActiveById();
    void verifierRappels();
}
