package Servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;



import DAO.PatrolmanDAO;

/**
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListPatrolmanControlle")
public class ListPatrolmanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private PatrolmanDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPatrolmanController() {
        super();
        //dao = new PatrolmanDAO();
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
