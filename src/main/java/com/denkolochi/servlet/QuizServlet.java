package com.denkolochi.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//package com.denkolochi.servlet;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import com.denkolochi.model.Quiz;
import com.denkolochi.dao.ImplQuestionDAO;
import com.denkolochi.dao.QuizDao;
import com.denkolochi.model.Question;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (session.getAttribute("quiz") == null || "restart".equals(request.getParameter("action"))) {
            Quiz quiz = chargerQuizDepuisDonnees();
            
            session.setAttribute("quiz", quiz);
            session.setAttribute("currentIndex", 0);
            session.setAttribute("score", 0);
            
            List<Integer> reponses = new ArrayList<>();
            for (int i = 0; i < quiz.getQuestions().size(); i++) {
                reponses.add(-1); 
            }
            session.setAttribute("reponsesUtilisateur", reponses);
        }

        this.getServletContext().getRequestDispatcher("/jeu_quiz.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        int currentIndex = (int) session.getAttribute("currentIndex");
        List<Integer> reponses = (List<Integer>) session.getAttribute("reponsesUtilisateur");

        if (quiz == null) {
            response.sendRedirect(request.getContextPath() + "/QuizServlet");
            return;
        }

        String reponseChoisie = request.getParameter("reponse");
        if (reponseChoisie != null) {
            reponses.set(currentIndex, Integer.parseInt(reponseChoisie));
        }

        String action = request.getParameter("nav");
        if ("suivant".equals(action) && currentIndex < quiz.getQuestions().size() - 1) {
            currentIndex++;
        } else if ("precedent".equals(action) && currentIndex > 0) {
            currentIndex--;
        }

        int scoreActuel = 0;
        List<Question> listeQuestions = quiz.getQuestions();
        for (int i = 0; i < listeQuestions.size(); i++) {
        	
            if (reponses.get(i) == 1) { 
                scoreActuel += listeQuestions.get(i).getScore();
            }
        }
        
       
        int scorePourcentage = (quiz.getScoreMax() > 0) ? (scoreActuel * 100) / quiz.getScoreMax() : 0;

        
        session.setAttribute("currentIndex", currentIndex);
        session.setAttribute("reponsesUtilisateur", reponses);
        session.setAttribute("score", scorePourcentage);

        response.sendRedirect(request.getContextPath() + "/QuizServlet");
    }

    
    private Quiz chargerQuizDepuisDonnees() {
    	QuizDao quizDao = new QuizDao();
    	ImplQuestionDAO questionDao = new ImplQuestionDAO();
        Quiz quiz = quizDao.findById(2);
        
        List<Question> liste = questionDao.recuperationQuestionsByIdQuiz(2);
        
        
        quiz.setQuestions(liste);
        return quiz;
    }
   /* private Quiz chargerQuizDepuisDonnees() {
        Quiz quiz = new Quiz(1, 1200, 100, 10, "Mortal Kombat Lore", "Quiz sur l'histoire de MK", 12, 99, null, 1, null);
        
        List<Question> liste = new ArrayList<>();
        liste.add(new Question("Qui est réellement Noob Saibot sous son masque d'ombre ?", 101, 30, 20, 1));
        liste.add(new Question("Quel studio développe la franchise Mortal Kombat ?", 102, 30, 20, 1));
        liste.add(new Question("Quel personnage possède un chapeau tranchant ?", 103, 30, 20, 1));
        liste.add(new Question("Dans quel royaume se déroule le tournoi principal ?", 104, 30, 40, 1));
        
        quiz.setQuestions(liste);
        return quiz;
    }*/
}