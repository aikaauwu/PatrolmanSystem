package patrol.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import patrol.dao.PatrolmanDAO;
import patrol.dao.ResidentDAO;
/**
 * Servlet implementation class PatrolmanViewProfileServlet
 */
public class PatrolmanViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PatrolmanDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatrolmanViewProfileServlet() {
        super();
        dao = new PatrolmanDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patrolmanUsername = request.getParameter("patrolmantUsername");
		request.setAttribute("patrolmans", PatrolmanDAO.getPatrolmanProfile(patrolmanUsername));
		RequestDispatcher view = request.getRequestDispatcher("Pat Profile.jsp");
		view.forward(request, response);
	}



}
