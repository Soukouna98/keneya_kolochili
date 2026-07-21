package com.keneya.kolochili.Config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.keneya.kolochili.Exception.UnauthorizedException;
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
        String method = request.getMethod();
        
         if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }   

        if (path.startsWith("/activites")) {
            return true;
        }

        if (path.startsWith("/api/plans")) {
            return true;
        }

        if ("POST".equalsIgnoreCase(method) && "/citoyens".equals(path)) {
            return true;
        }

        return path.startsWith("/auth")
                || path.startsWith("/swagger-ui")
                || path.startsWith("/v3/api-docs")
                || path.startsWith("/swagger-resources")
                || path.startsWith("/webjars");
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
                throw new UnauthorizedException("Session introuvable");
            }

            Utilisateur user = (Utilisateur) session.getAttribute("user");

            if (user == null) {
                throw new UnauthorizedException("Utilisateur non connecté");

            }

            CurrentUserContext.set(user);

            filterChain.doFilter(request, response);

        } finally {

            CurrentUserContext.clear();
        }
    }

}
