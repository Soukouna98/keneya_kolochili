package com.denkolochi.servlet;

import java.io.IOException;
import java.util.List;

import com.denkolochi.dao.ImplHistoriqueDao;
import com.denkolochi.model.Historique;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/historique")
public class HistoriqueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Le DAO est déclaré ici, mais on s'assure qu'il utilise bien la 
    // nouvelle logique (connexion demandée à la volée dans ses méthodes).
    private ImplHistoriqueDao dao;

    @Override
    public void init() throws ServletException {
        // Bonne pratique JEE : Initialisation des composants dans le init()
        this.dao = new ImplHistoriqueDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id_enfants");
        
        // Sécurisation : Vérification que le paramètre existe et n'est pas vide
        if (idParam == null || idParam.trim().isEmpty()) {
            // Option A : Rediriger vers une page d'erreur ou d'accueil
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Le paramètre id_enfants est manquant.");
            return; 
        }

        try {
            int idEnfant = Integer.parseInt(idParam);
            
            System.out.println(" Récupération de l'enfant ID : " + idEnfant + " **********");

            // Récupération de la liste (Grâce au correctif du DAO, la connexion est fraîche et active)
            List<Historique> historiques = dao.findByEnfant(idEnfant);
            
            // Log de débug dans la console
            System.out.println("Nombre d'historiques trouvés : " + historiques.size());

            // Transmission des données à la JSP
            request.setAttribute("historiques", historiques);

            // Forward vers la vue
            this.getServletContext().getRequestDispatcher("/historique.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Si le paramètre id_enfants n'est pas un nombre valide (ex: /historique?id_enfants=abc)
            System.err.println("Erreur de format de l'ID : " + idParam);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'identifiant de l'enfant doit être un nombre valide.");
        }
    }
}