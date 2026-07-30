package com.keneya.kolochili.Service.rappel;

import java.time.LocalDateTime;
import java.util.List;

import com.keneya.kolochili.Enumeration.TypeFrequence;
import com.keneya.kolochili.MODEL.Notification;
import com.keneya.kolochili.Repository.NotificationRepository;
import jdk.jshell.execution.Util;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.IService.rappel.Irappel;
import com.keneya.kolochili.MODEL.Rappel;
import com.keneya.kolochili.MODEL.Utilisateur;
import com.keneya.kolochili.Repository.CitoyenRepository;
import com.keneya.kolochili.Repository.RappelRepository;
import com.keneya.kolochili.DTO.Request.RappelDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RappelService  implements Irappel {

    private final RappelRepository rappelRepository;
    private final CitoyenRepository citoyenRepository;
    private final NotificationRepository notificationRepository;

    @Override
    public Rappel creeRappel(RappelDTO rappel) {
        Utilisateur user = CurrentUserContext.get();

		Rappel r = new Rappel();
        r.setCitoyen(citoyenRepository.findById(user.getId()).get());
        r.setNom_medicament(rappel.getNom_medicament());
        r.setFrequence(rappel.getFrequence());
        r.setIntervalle(rappel.getIntervalle());
        r.setDateCreation(LocalDateTime.now());
        r.setDateDebut(rappel.getDateDebut());
        r.setDateFin(rappel.getDateFin());
        r.setDateRappel(rappel.getDateDebut());
        r.setArchive(false);
        r.setTerminer(false);

        return rappelRepository.save(r);
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
        
//	@Override
//	public 	List<Rappel> getRappelsDus(){
//        LocalDateTime now = LocalDateTime.now();
//        Utilisateur user = CurrentUserContext.get();
//        List<Rappel> rappelDus = rappelRepository.findRappelDusParCitoyen(user.getId(), now);
//        return  rappelDus;
//	}


	@Override 
	public 	List<Rappel> getRappelsActifs(){
        Utilisateur user = CurrentUserContext.get();
		return rappelRepository.findRappelActiveByCitoyen(user.getId(), LocalDateTime.now());
	}

    @Override
    public List<Rappel> getRappelsTerminer() {
        Utilisateur user = CurrentUserContext.get();
        return rappelRepository.findRappelTerminerCitoyen(user.getId());
    }

    @Override
    public void TraiterTousRappelsDus() {
        Utilisateur user = CurrentUserContext.get();
        LocalDateTime now = LocalDateTime.now();
        List<Rappel> rappelDus = rappelRepository.TraiterRappelDus(now);

        for (Rappel r : rappelDus){
            Notification notif = new Notification();
            notif.setRappel(r);
            notif.setCitoyen(r.getCitoyen());
            notif.setDateDeclenchement(r.getDateRappel());
            notificationRepository.save(notif);

            avanceEcheance(r);
        }
        rappelRepository.saveAll(rappelDus);
    }


    private void avanceEcheance(Rappel r){
            if(r.getFrequence() == TypeFrequence.FIXE){
                LocalDateTime prochain = r.getDateRappel().plusHours(r.getIntervalle());
                boolean depasseDateFin = r.getDateFin() != null && prochain.isAfter(r.getDateFin());
                if(depasseDateFin){
                    r.setTerminer(true);
                }
                r.setDateRappel(prochain);
            }else {
                r.setArchive(true);
            }
    }



}
