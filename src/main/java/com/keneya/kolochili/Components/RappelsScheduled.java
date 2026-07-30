package com.keneya.kolochili.Components;

import com.keneya.kolochili.Service.rappel.RappelService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RappelsScheduled {

    private  final RappelService rappelService;

    @Scheduled(fixedRate = 5000)
    public  void TraiterTousRappelsDus (){
             rappelService.TraiterTousRappelsDus();
    }
}
