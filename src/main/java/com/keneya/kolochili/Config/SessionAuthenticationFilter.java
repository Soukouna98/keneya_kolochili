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
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        String method = request.getMethod();

        if (path.startsWith("/auth/")) {
            return true;
        }
        return "/citoyens".equals(path) && "POST".equalsIgnoreCase(method);

        
    }

        

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        try {

            HttpSession session
                    = request.getSession(false);

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
