package Servlet;

import javax.servlet.RequestDispatcher;  
import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.scheduleDao;
import DAO.ResidentDAO;
import Model.Resident;
 

/**
 * Servlet implementation class listScheduleController
 */
public class listScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private scheduleDao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listScheduleController() {
        super();
      //  dao = new scheduleDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String scheduleId = request.getParameter("scheduleId");
		
		String residentUsername = request.getParameter("residentUsername");
		
		request.setAttribute("residentUsername", residentUsername);
		request.setAttribute("schedules",scheduleDao.getScheduleDetails());
		RequestDispatcher view = request.getRequestDispatcher("res viewSchedule.jsp");
		view.forward(request,  response);
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
	 
	    	String residentUsername = request.getParameter("residentUsername");
	    	
	    	Resident resident = new Resident(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
	 
	    	//meow 
	    	
	    	resident.setResidentUsername(residentUsername);
	    	
	    	
	             request.setAttribute("residentUsername", residentUsername); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
	         }


}
