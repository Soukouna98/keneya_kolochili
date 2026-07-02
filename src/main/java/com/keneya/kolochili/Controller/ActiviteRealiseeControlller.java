package com.keneya.kolochili.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.Request.Activite.ActiviteRealiseeDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.Activite.ActiviteRealiseeDTOResponse;
import com.keneya.kolochili.Service.ActiviteRealiseeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/activites-realisees", produces = "application/json")
@RequiredArgsConstructor
public class ActiviteRealiseeControlller {

    private final ActiviteRealiseeService activiteRealiseeService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<ActiviteRealiseeDTORequest>> creer(@Valid @RequestBody ActiviteRealiseeDTORequest dto) {
        activiteRealiseeService.creer(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(
                        true,
                        "Activite realisee inseree avec succes",
                        null
                ));
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<APIResponse<ActiviteRealiseeDTOResponse>> modifier(@Valid @RequestBody ActiviteRealiseeDTORequest dto, @PathVariable Long id) {
        activiteRealiseeService.modifier(dto, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Activite realisee modifiee avec succes",
                        null
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ActiviteRealiseeDTOResponse>> lire(@PathVariable Long id) {
        ActiviteRealiseeDTOResponse response = activiteRealiseeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Activite realisee trouvee avec succes",
                        response
                ));
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ActiviteRealiseeDTOResponse>>> liste() {
        List<ActiviteRealiseeDTOResponse> list = activiteRealiseeService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Voici la liste des activites realisees",
                        list
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Object>> supprimer(@PathVariable Long id) {
        activiteRealiseeService.supprimer(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Activite realisee supprimee avec succes",
                        null
                ));
    }
}

