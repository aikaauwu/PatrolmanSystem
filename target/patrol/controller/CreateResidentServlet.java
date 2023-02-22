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
 * Servlet implementation class CreateResidentController
 */
@WebServlet("/CreateResident")
public class CreateResidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ResidentDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateResidentServlet() {
        super();
        dao = new ResidentDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Resident s = new Resident();
		s.setResidentId(Integer.parseInt(request.getParameter("residentId")));
		s.setResidentUsername(request.getParameter("residentUsername"));
		s.setResidentName(request.getParameter("residentName"));
		s.setResidentPassword(request.getParameter("residentPassword"));
		s.setResidentAddress(request.getParameter("residentAddress"));
		s.setResidentEmail(request.getParameter("residentEmail"));
		s.setResidentPhoneNum(Integer.parseInt(request.getParameter("residentPhoneNum")));
		
		//meow
		
		dao.addResident(s); //invoke method addShawl() in ShawlDAO
		
		request.setAttribute("residents", ResidentDAO.getResidentDetails());
		RequestDispatcher view = request.getRequestDispatcher("index.jsp"); //dia pergi mana lepas tu
		view.forward(request, response);
		
	}

}
