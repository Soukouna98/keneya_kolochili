package com.denkolochi.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.dao.ImplEnfantDAO;
import com.denkolochi.dao.ImplParentDAO;
import com.denkolochi.model.Enfant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletListeUtilisateur
 */
@WebServlet("/ServletListeUtilisateur")
public class ServletListeUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<Enfant> lst;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeUtilisateur() {
        super();
        // TODO Auto-generated constructor stub    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("liste", lst);
		request.getRequestDispatcher("/WEB-INF/views/Dashboard/listeUtilisateurs.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
