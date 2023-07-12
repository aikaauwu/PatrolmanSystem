package Servlet;

import java.io.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import DAO.PatrolmanDAO;
import Model.Patrolman;


/**
 * Servlet implementation class UpdateShawlController
 */
/**
 * Servlet implementation class UpdateShawlController
 */
@WebServlet("/UpdatePatrolmanz")
public class UpdatePatrolman extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatrolmanDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatrolman() {
        super();
        dao = new PatrolmanDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patrolmanUsername = (request.getParameter("patrolmanUsername"));
		request.setAttribute("patrolman", PatrolmanDAO.getPatrolmanProfile(patrolmanUsername));
		RequestDispatcher view = request.getRequestDispatcher("comm UpdatePat.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Patrolman p = new Patrolman();
		p.setPatrolmanId(request.getParameter("patrolmanId"));
		p.setResidentId(request.getParameter("residentId"));
		p.setPatrolmanUsername(request.getParameter("patrolmanUsername"));
		p.setPatrolmanPassword(request.getParameter("patrolmanPassword"));
		
		dao.updatePatrolman(p); 
		
		request.setAttribute("patrolman", PatrolmanDAO.getPatrolmanDetails());
		RequestDispatcher view = request.getRequestDispatcher("HOMEPAGE COM.jsp");
		view.forward(request, response);
	}

}
//n