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
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListResidentController")
public class ListResidentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListResidentController() {
        super();
        dao = new ResidentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("residents", ResidentDAO.getResidentDetails());
		RequestDispatcher view = request.getRequestDispatcher("Comm ViewRes.jsp");
		view.forward(request, response);
	}



}
