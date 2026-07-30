package com.keneya.kolochili.Service.notification;


import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.MODEL.Notification;
import com.keneya.kolochili.MODEL.Utilisateur;
import com.keneya.kolochili.Repository.NotificationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class NotificationService {
    private  final NotificationRepository notificationRepository;

    public List<Notification> getNotifications(){
        Utilisateur user = CurrentUserContext.get();
        return notificationRepository.findNotificationNotLueParCitoyen(user.getId());
    }

    public  void marquerCommeLus(Long id){
        Utilisateur user = CurrentUserContext.get();
        Notification notif = notificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Notification introuvable"));
        notif.setLue(true);
        notificationRepository.save(notif);
    }
}
