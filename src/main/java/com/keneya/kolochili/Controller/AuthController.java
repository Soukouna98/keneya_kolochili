package com.keneya.kolochili.Controller;


import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Response.User.UserDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {

    private final IServiceUser userService;

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<APIResponse<UserDTOResponse>> login(@Valid @RequestBody LoginDTOResquest loginRequest, HttpSession session) {
        Utilisateur user = userService.login(loginRequest);
        session.setAttribute("user", user);
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Login successful",
                        UserDTOResponse.fromEntity(user))
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

    @GetMapping("/me")
    public ResponseEntity<APIResponse<UserDTOResponse>> getMe( HttpSession session) {
        Utilisateur user    = (Utilisateur) session.getAttribute("user");

        if(user == null) {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(
                new APIResponse<>(
                true,
                "Tout le monde est connecter",
                UserDTOResponse.fromEntity(user)));
    }
}