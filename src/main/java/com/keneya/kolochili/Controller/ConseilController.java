package com.keneya.kolochili.Controller;

import com.keneya.kolochili.MODEL.Conseil;
import com.keneya.kolochili.Service.User.ConseilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conseils")
public class ConseilController {

    private final ConseilService conseilService;

    public ConseilController(ConseilService conseilService) {
        this.conseilService = conseilService;
    }

    // 1. Endpoint : Lister tous les conseils -> GET /api/conseils
    @GetMapping
    public ResponseEntity<List<Conseil>> getAllConseils() {
        List<Conseil> conseils = conseilService.obtenirTousLesConseils();
        return new ResponseEntity<>(conseils, HttpStatus.OK); // Code 200 OK
    }

    // 2. Endpoint : Détails d'un conseil -> GET /api/conseils/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Conseil> getConseilById(@PathVariable("id") int id) {
        return conseilService.obtenirConseilParId(id)
                .map(conseil -> new ResponseEntity<>(conseil, HttpStatus.OK)) // Code 200 OK
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Code 404 si pas trouvé
    }

    // 3. Endpoint : Création d'un conseil -> POST /api/conseils
    @PostMapping // CORRECTION ICI : @HttpPost devient @PostMapping
    public ResponseEntity<Conseil> createConseil(@RequestBody Conseil conseil) {
        Conseil nouveauConseil = conseilService.creerConseil(conseil);
        return new ResponseEntity<>(nouveauConseil, HttpStatus.CREATED); // Code 201 Created
    }

    // 4. Endpoint : Modification d'un conseil -> PUT /api/conseils/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Conseil> updateConseil(@PathVariable("id") int id, @RequestBody Conseil conseilModifie) {
        try {
            Conseil conseilMisAJour = conseilService.modifierConseil(id, conseilModifie);
            return new ResponseEntity<>(conseilMisAJour, HttpStatus.OK); // Code 200 OK
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Endpoint : Suppression d'un conseil -> DELETE /api/conseils/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConseil(@PathVariable("id") int id) {
        try {
            conseilService.supprimerConseil(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Code 204 No Content
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}