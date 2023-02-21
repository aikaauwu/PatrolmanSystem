package patrol.controller;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import patrol.dao.ResidentDAO;

/**
 * Servlet implementation class ViewShawlController
 */
@WebServlet("/ResViewProfileController")
public class ResidentViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentViewProfileServlet() {
        super();
        dao = new ResidentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String residentUsername = request.getParameter("residentUsername");
		request.setAttribute("resident", ResidentDAO.getResidentProfile(residentUsername));
		RequestDispatcher view = request.getRequestDispatcher("Res Profile.jsp");
		view.forward(request, response);
	}


}
