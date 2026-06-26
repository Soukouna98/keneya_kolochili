package com.keneya.kolochili.Controller;

import DTO.Request.User.AgentDTORequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @PostMapping("/inscription")
    public ResponseEntity<String> creerAgent(@RequestBody AgentDTORequest agentDTO) {
        // 1. Sauvegarder l'utilisateur en base de données
        // 2. Sauvegarder l'agent lié à cet utilisateur en base de données
        return new ResponseEntity<>("Agent créé avec succès !", HttpStatus.CREATED);
    }
}