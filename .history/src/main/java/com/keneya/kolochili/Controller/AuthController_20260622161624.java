package com.keneya.kolochili.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aon.pheno.keneya.DTO.Request.LoginDTOResquest;
import aon.pheno.keneya.DTO.Response.APIResponse;
import aon.pheno.keneya.Entity.User.User;
import aon.pheno.keneya.IService.User.IServiceUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "auth", produces = "application/json")
@RequiredArgsConstructor
public class AuthController {

    private final IServiceUser userService;

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<APIResponse<User>> login(@Valid @RequestBody LoginDTOResquest loginRequest, HttpSession session) {
        User user = userService.login(loginRequest);
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
        User user = (User) session.getAttribute("user");
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
}