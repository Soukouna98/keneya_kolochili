package com.keneya.kolochili.Service.rappel;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.IService.rappel.Irappel;
import com.keneya.kolochili.MODEL.Rappel;
import com.keneya.kolochili.MODEL.Utilisateur;
import com.keneya.kolochili.Repository.CitoyenRepository;
import com.keneya.kolochili.Repository.RappelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RappelService implements Irappel {

    private final RappelRepository rappelRepository;
    private final CitoyenRepository citoyenRepository;
    
    @Override
    public Rappel creeRappel(Rappel rappel) {
        Utilisateur user = CurrentUserContext.get();
        rappel.setCitoyen(citoyenRepository.findById(user.getId()).get());
        return rappelRepository.save(rappel);
    }

    @Override
    public List<Rappel> read() {
       return rappelRepository.findAll();
    }

  @Override
public Rappel updateRappel(Long id, Rappel rappel) {
    return rappelRepository.findById(id)
        .map(p -> {
            p.setArchive(rappel.isArchive());
            p.setDateCreation(rappel.getDateCreation());
            p.setDateDebut(rappel.getDateDebut());
            p.setDateFin(rappel.getDateFin());
            p.setDateRappel(rappel.getDateRappel());
            p.setIntervalle(rappel.getIntervalle());
            p.setNom_medicament(rappel.getNom_medicament());
            p.setFrequence(rappel.getFrequence());
            return rappelRepository.save(p);
        })
        .orElseThrow(() -> new RuntimeException("rappel pas trouvé"));
}
    @Override
    public String deleteRappel(Long id) {
           rappelRepository.findById(id)
        .map(p -> {
            p.setArchive(true);
           
            return rappelRepository.save(p);
        })
        .orElseThrow(() -> new RuntimeException("Pas  Supprimé"));
		return "Rappel supprimé avec succès";
    }

    @Override
    public List<Rappel> ListeRappelActiveById() {
        Utilisateur user = CurrentUserContext.get();

        return rappelRepository.findByCitoyenIdAndArchiveFalseAndDateRappelLessThanEqual(user.getId(), LocalDateTime.now());
    }

    @Override
    @Scheduled( fixedRate =  6000)
    public void verifierRappels() {
        Utilisateur user = CurrentUserContext.get();
      List<Rappel> rappels =  rappelRepository.findByCitoyenIdAndArchiveFalseAndDateRappelLessThanEqual(user.getId(), LocalDateTime.now());
        for (Rappel rappel : rappels) {
        System.out.println("C'est l'heure de prendre " + rappel.getNom_medicament());
    }
    }
        
    


}
