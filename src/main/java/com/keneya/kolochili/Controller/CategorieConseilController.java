package com.keneya.kolochili.Controller;

import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.keneya.kolochili.DTO.Request.CategorieConseilDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieConseilDTOResponse;
import com.keneya.kolochili.IService.ICategorieConseilService;

@RestController
@RequestMapping(path = "api/categories-conseils", produces = "application/json")
@RequiredArgsConstructor
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

    @GetMapping("/{id}")
    public CategorieConseilDTOResponse rechercher(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<CategorieConseilDTOResponse> lister() {
        return service.getAll();
    }
}