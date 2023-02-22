package patrol.controller;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patrol.dao.ResidentDAO;
import patrol.model.Resident;

/**
 * Servlet implementation class UpdateShawlController
 */
@WebServlet("/ResiUpdateDetailServlet")
public class ResidentUpdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentUpdateDetailServlet() {
        super();
        dao = new ResidentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int residentId = Integer.parseInt(request.getParameter("residentId"));
		request.setAttribute("resident", ResidentDAO.getResidentDetail(residentId));
		RequestDispatcher view = request.getRequestDispatcher("R updateProdile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Resident s = new Resident();
		s.setResidentId(Integer.parseInt(request.getParameter("residentId")));
		s.setResidentName(request.getParameter("residentName"));
		s.setResidentUsername(request.getParameter("residentUsername"));
		s.setResidentEmail(request.getParameter("residentEmail"));
		s.setResidentPhoneNum(Integer.parseInt(request.getParameter("residentPhoneNum")));
		s.setResidentPassword(request.getParameter("residentPassword"));
		s.setResidentName(request.getParameter("residentName"));
		
		dao.updateResident(s); 
		
		RequestDispatcher view = request.getRequestDispatcher("ResidentViewProfileServlet");
		view.forward(request, response);
	}

}