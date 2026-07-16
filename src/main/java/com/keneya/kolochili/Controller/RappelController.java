package com.keneya.kolochili.Controller;

import java.util.List;
import java.util.stream.Collectors;

import com.keneya.kolochili.DTO.Request.RappelDTO;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.RappelResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RappelController {
private final RappelService rappelService ;

        @PostMapping("/create")
        public ResponseEntity<Rappel> create(@Valid @RequestBody RappelDTO r) {
            Rappel rappel = rappelService.creeRappel(r);
            return ResponseEntity.ok(rappel);
        }

        @GetMapping("/dus")
        public ResponseEntity<List<RappelResponseDTO>>rappelsDus(){
            List<Rappel> rappelsDus = rappelService.getRappelsDus();
            List<RappelResponseDTO> dus = rappelsDus.stream().map(RappelResponseDTO::new).toList();
            return  ResponseEntity.ok(dus);

        }


    @GetMapping("/rappel-actif")
    public ResponseEntity<List<RappelResponseDTO>>rappelsActif(){
        List<Rappel> rappelsactifs = rappelService.getRappelsActifs();
        List<RappelResponseDTO> actif = rappelsactifs.stream().map(RappelResponseDTO::new).toList();
        return  ResponseEntity.ok(actif);
    }

        
        @GetMapping("/read")
        public ResponseEntity<List<RappelResponseDTO>> allRappels() {
            List<Rappel> allrappels = rappelService.read();
            List<RappelResponseDTO> rappelTous = allrappels.stream().map(RappelResponseDTO::new).toList() ;
            return ResponseEntity.ok(rappelTous) ;
        }
//

//        @PutMapping("/update/{id}")
//        public Rappel update (@PathVariable Long id, @RequestBody Rappel rappel) {
//
//            return rappelService.updateRappel(id, rappel);
//
//        }
//
        @DeleteMapping("/delete/{id}")
        public String delete (@PathVariable Long id){
            return rappelService.deleteRappel(id);
        }


        

}
