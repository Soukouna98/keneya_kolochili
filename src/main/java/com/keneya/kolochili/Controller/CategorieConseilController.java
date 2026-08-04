package com.keneya.kolochili.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.Request.CategorieConseilDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieConseilDTOResponse;
import com.keneya.kolochili.IService.ICategorieConseilService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "categories-conseils", produces = "application/json")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class CategorieConseilController {

    private final ICategorieConseilService service;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void ajouter(@Valid @RequestBody CategorieConseilDTORequest request) {
       
        service.creer(request);
    }

    @PutMapping("/{id}")
    public void modifier(@PathVariable Long id, @Valid @RequestBody CategorieConseilDTORequest request) {
        service.modifier(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }

    @PatchMapping("/{id}/de-archiver")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desarchiver(@PathVariable Long id) {
        service.desarchiver(id);
    }

    @GetMapping("/{id}")
    public CategorieConseilDTOResponse rechercher(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<CategorieConseilDTOResponse> lister() {
        return service.getAll();
    }
}
