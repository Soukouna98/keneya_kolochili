package com.keneya.kolochili.Repository;

import com.keneya.kolochili.MODEL.Notification;
import com.keneya.kolochili.MODEL.Rappel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {

    @Query("select n from Notification n where n.citoyen.id = :citoyenId and n.lue = false")
    List<Notification> findNotificationNotLueParCitoyen(@Param("citoyenId") Long citoyenId);

}
