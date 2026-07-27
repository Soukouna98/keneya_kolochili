package com.keneya.kolochili.Controller;

import org.springframework.http.HttpStatus; // <-- Ajouté pour gérer le statut 401
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin; // <-- Ajouté

import com.keneya.kolochili.DTO.Request.LoginDTOResquest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.IService.User.IServiceUser;
import com.keneya.kolochili.MODEL.Utilisateur;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "auth", produces = "application/json")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true") // <-- AJOUT CRUCIAL POUR LES COOKIES
public class AuthController {

    private final IServiceUser userService;

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<APIResponse<Object>> login(@Valid @RequestBody LoginDTOResquest loginRequest, HttpSession session) {
        Utilisateur user = userService.login(loginRequest);
        session.setAttribute("user", user);
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Login successful",
                        null)
        );
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<APIResponse<Object>> logout(HttpSession session) {
        Utilisateur user = (Utilisateur) session.getAttribute("user");
        if (session.getAttribute("user") != null) {
            session.invalidate();
            return ResponseEntity.ok(
                    new APIResponse<>(
                            true,
                            "Logout successful " + user.getEmail(),
                            null)
            );
        }
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Personne n'est connecte ",
                        null)
        );
    }

    // <-- AJOUT : Endpoint pour vérifier si l'utilisateur est connecté (utilisé par le Guard Angular)
    @GetMapping(path = "/me")
    public ResponseEntity<APIResponse<Object>> getCurrentUser(HttpSession session) {
        Utilisateur user = (Utilisateur) session.getAttribute("user");

        if (user != null) {
            // L'utilisateur est connecté, on renvoie true et les infos de l'utilisateur (ou null si on veut juste un statut)
            return ResponseEntity.ok(
                    new APIResponse<>(
                            true,
                            "User is logged in",
                            user) // Vous pouvez retourner user ici ou null si vous préférez
            );
        } else {
            // Aucun utilisateur connecté, on renvoie une erreur 401 (UNAUTHORIZED)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new APIResponse<>(
                            false,
                            "User is not logged in",
                            null)
                    );
        }
    }
}