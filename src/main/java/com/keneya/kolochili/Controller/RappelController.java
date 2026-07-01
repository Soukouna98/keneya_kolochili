package com.keneya.kolochili.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.MODEL.Rappel;
import com.keneya.kolochili.Service.rappel.RappelService;

import lombok.AllArgsConstructor;





@RestController
@RequestMapping("/rappels")
@AllArgsConstructor
public class RappelController {
private final RappelService rappelService ;

        @PostMapping("/create")
        public Rappel create(@RequestBody Rappel rappel) {
            return rappelService.creeRappel(rappel); 
        }
        
        @GetMapping("/read")
        public List<Rappel> read() {
            return rappelService.read();
        }

         @GetMapping("/myrappel")
        public List<Rappel> allmyrappels() {
            return rappelService.ListeRappelActiveById();
        }
        @PutMapping("/update/{id}")
        public Rappel update (@PathVariable Long id, @RequestBody Rappel rappel) {
            
            return rappelService.updateRappel(id, rappel);

        }

        @DeleteMapping("/delete/{id}")
        public String delete (@PathVariable Long id){
            return rappelService.deleteRappel(id);
        }


        

}
