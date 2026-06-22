package com.keneya.kolochili.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/conseils") // L'URL de base définie en Partie 2
public class ConseilController {

    @GetMapping // Correspond à la méthode GET du tableau de conception
    public List<Map<String, String>> getTousLesConseils() {
        // On simule une réponse JSON pour tester sans base de données
        return List.of(
            Map.of(
                "id", "1",
                "titre", "Hydratation en période de chaleur",
                "contenu", "Il est fortement recommandé de boire au moins 2,5 litres d'eau par jour."
            )
        );
    }
}
