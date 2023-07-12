package Servlet;

import java.io.IOException;    
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;


import DAO.ResidentDAO;
import Model.Resident;
 
/**
 * Servlet implementation class ViewShawlController 
 */
/**
 * Servlet implementation class UpdateShawlController
 */
@WebServlet("/CommUpdateResidentControlle")
public class CommUpdateResidentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommUpdateResidentController() {
        super();
        dao = new ResidentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String residentId = request.getParameter("residentId");
		request.setAttribute("resident", ResidentDAO.getResidentDetail(residentId));
		RequestDispatcher view = request.getRequestDispatcher("comm UpdateRes.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Resident s = new Resident();
		s.setResidentId(request.getParameter("residentId"));
		s.setResidentName(request.getParameter("residentName"));
		s.setResidentPassword(request.getParameter("residentPassword"));
		s.setResidentEmail(request.getParameter("residentEmail"));
		s.setResidentUsername(request.getParameter("residentUsername"));
		s.setResidentAddress(request.getParameter("residentAddress"));
		s.setResidentPhoneNum(Integer.parseInt(request.getParameter("residentPhoneNum")));
		
		
		dao.updateResident(s); 
		
		request.setAttribute("residents", ResidentDAO.getResidentDetails());
		RequestDispatcher view = request.getRequestDispatcher("HOMEPAGE COM.jsp");
		view.forward(request, response);
	}

}


