package patrol.controller;

import java.io.IOException;    


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import patrol.dao.PatrolmanDAO;
import patrol.model.Patrolman;

/**
 * Servlet implementation class CreateResidentController
 */
@WebServlet("/CreatePatrolman")
public class CreatePatrolmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PatrolmanDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePatrolmanServlet() {
        super();
        dao = new PatrolmanDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Patrolman s = new Patrolman();
		s.setPatrolmanId(request.getParameter("patrolmanId"));
		s.setResidentId(Integer.parseInt(request.getParameter("residentId")));
		s.setPatrolmanUsername(request.getParameter("patrolmanUsername"));
		s.setPatrolmanPassword(request.getParameter("patrolmanPassword"));
		
		//meow
		
		dao.addPatrolman(s); //invoke method addShawl() in ShawlDAO
		
		request.setAttribute("patrolmans", PatrolmanDAO.getPatrolmanDetails());
		RequestDispatcher view = request.getRequestDispatcher("/HOMEPAGE COM.jsp"); //RequestDispatcher view = request.getRequestDispatcher("ListPatrolmanController");
		view.forward(request, response);
		
		 
		
	}

}
