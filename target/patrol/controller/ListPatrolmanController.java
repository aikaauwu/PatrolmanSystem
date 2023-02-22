package patrol.controller;

import java.io.IOException;   

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import patrol.dao.PatrolmanDAO; 

/**
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListPatrolmanController")
public class ListPatrolmanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatrolmanDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPatrolmanController() {
        super();
        dao = new PatrolmanDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("patrolmans", PatrolmanDAO.getPatrolmanDetails());
		RequestDispatcher view = request.getRequestDispatcher("comm viewPat.jsp");
		view.forward(request, response);
	}



}
