package patrol.controller;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import patrol.model.Location;
import patrol.dao.locationDAO;

public class viewLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private locationDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewLocation() {
        super();
        dao = new locationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int locationId = Integer.parseInt(request.getParameter("locationId"));
		request.setAttribute("location",locationDAO.getLocationDetail());
		RequestDispatcher view = request.getRequestDispatcher("viewDetailLocation.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
