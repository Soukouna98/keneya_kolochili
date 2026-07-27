package com.keneya.kolochili.DTO.Response;

import com.keneya.kolochili.MODEL.Notification;

import java.time.LocalDateTime;

public record NotificationResponseDTO(
        Long id,
        RappelResponseDTO rappel,
        LocalDateTime dateDeclenchement,
        boolean lue
) {
    public static NotificationResponseDTO fromEntity(Notification notif) {
        return new NotificationResponseDTO(
                notif.getId(),
                RappelResponseDTO.fromEntity(notif.getRappel()),
                notif.getDateDeclenchement(),
                notif.isLue()
        );
    }
}
