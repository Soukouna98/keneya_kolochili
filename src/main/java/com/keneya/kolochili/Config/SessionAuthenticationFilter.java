package com.keneya.kolochili.Config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.keneya.kolochili.MODEL.Utilisateur;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SessionAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        // On exclut /auth ET les routes de documentation Swagger / OpenAPI
        return path.startsWith("/auth") 
            || path.startsWith("/swagger-ui") 
            || path.startsWith("/v3/api-docs");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(false);

            if (session == null) {
                sendUnauthorizedResponse(response, "Session introuvable. Veuillez vous connecter.");
                return; // On arrête la chaîne de filtres ici
            }

            Utilisateur user = (Utilisateur) session.getAttribute("user");

            if (user == null) {
                sendUnauthorizedResponse(response, "Utilisateur non connecté ou session expirée.");
                return; // On arrête la chaîne de filtres ici
            }

            CurrentUserContext.set(user);
            filterChain.doFilter(request, response);

        } finally {
            CurrentUserContext.clear();
        }
    }

    // Méthode utilitaire pour renvoyer un JSON propre au lieu de lever une exception brute
    private void sendUnauthorizedResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Code 401
        response.setContentType("application/json;charset=UTF-8");
        
        String jsonResponse = String.format("{\"status\": 401, \"error\": \"Unauthorized\", \"message\": \"%s\"}", message);
        response.getWriter().write(jsonResponse);
    }
}