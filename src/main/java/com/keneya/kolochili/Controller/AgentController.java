package com.keneya.kolochili.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.Request.User.AgentDTORequest;

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