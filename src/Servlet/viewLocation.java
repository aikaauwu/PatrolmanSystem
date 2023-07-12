package Servlet;

import javax.servlet.RequestDispatcher;  
import java.io.IOException; 
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//import Model.Location;
import DAO.locationDAO;

public class viewLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private locationDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewLocation() {
        super();
        //dao = new locationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int locationId = Integer.parseInt(request.getParameter("locationId"));
		request.setAttribute("locations",locationDAO.getLocationDetail(locationId));
		RequestDispatcher view = request.getRequestDispatcher("viewDetailLocation.jsp");
		view.forward(request, response);
	}

	/**AJAX
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
