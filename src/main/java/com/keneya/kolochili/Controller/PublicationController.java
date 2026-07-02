package com.keneya.kolochili.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.keneya.kolochili.DTO.Request.PublicationDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.PublicationDTOResponse;
import com.keneya.kolochili.IService.IServicePublication;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "publications", produces = "application/json")
@RequiredArgsConstructor
public class PublicationController {

    private final IServicePublication service;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<Void>> ajouter(
            @Valid @RequestBody PublicationDTORequest request) {

        service.creer(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(
                        true,
                        "Publication créée avec succès.",
                        null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> modifier(
            @PathVariable Long id,
            @Valid @RequestBody PublicationDTORequest request) {

        service.modifier(request, id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Publication modifiée avec succès.",
                        null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> supprimer(@PathVariable Long id) {

        service.supprimer(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Publication archivée avec succès.",
                        null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<PublicationDTOResponse>> rechercher(@PathVariable Long id) {

        PublicationDTOResponse response = service.findById(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Publication trouvée avec succès.",
                        response));
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<PublicationDTOResponse>>> lister() {

        List<PublicationDTOResponse> publications = service.getAll();

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Liste des publications récupérée avec succès.",
                        publications));
    }

    @GetMapping("/archives")
    public ResponseEntity<APIResponse<List<PublicationDTOResponse>>> listerArchives() {

        List<PublicationDTOResponse> publications = service.getArchives();

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Liste des publications archivées récupérée avec succès.",
                        publications));
    }
}