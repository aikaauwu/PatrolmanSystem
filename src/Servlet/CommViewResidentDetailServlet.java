package Servlet;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;


import DAO.ResidentDAO;

/**
 * Servlet implementation class ViewShawlController
 */
@WebServlet("/CommViewResidentDetailServle")
public class CommViewResidentDetailServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	private ResidentDAO dao;  
   
    public CommViewResidentDetailServlet() {
        super();
        dao = new ResidentDAO();
        // TODO Auto-generated constructor stub
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String residentId = request.getParameter("residentId");
		request.setAttribute("resident", ResidentDAO.getResidentDetail(residentId));
		RequestDispatcher view = request.getRequestDispatcher("comm ViewResProfile.jsp");
		view.forward(request, response);
	}


}
