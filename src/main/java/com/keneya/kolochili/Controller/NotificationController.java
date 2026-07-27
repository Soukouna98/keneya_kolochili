package com.keneya.kolochili.Controller;

import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.NotificationResponseDTO;
import com.keneya.kolochili.MODEL.Notification;
import com.keneya.kolochili.Service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationResponseDTO> > getNotifications() {
         List<Notification> notifications = notificationService.getNotifications();
         List<NotificationResponseDTO> notificationResponseDTOs = notifications.stream().map(NotificationResponseDTO::fromEntity).toList();
         return ResponseEntity.ok(notificationResponseDTOs);
    }

    @PostMapping("{id}")
    public ResponseEntity marquerCommeLus(@PathVariable Long id){

        notificationService.marquerCommeLus(id);
        return ResponseEntity.ok().build();
    }
}
