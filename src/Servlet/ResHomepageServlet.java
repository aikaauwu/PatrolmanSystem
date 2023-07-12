package Servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Resident;
import DAO.ResidentDAO;
 
public class ResHomepageServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResHomepageServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
    	String residentUsername = request.getParameter("residentUsername");
    	
    	Resident resident = new Resident(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
    	//meow 
    	
    	resident.setResidentUsername(residentUsername);
    	
    	
             request.setAttribute("residentUsername", residentUsername); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.getRequestDispatcher("/HOMEPAGE RESIDENTS.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page (aka dia pi mana lepas log in)
         }
        
    }
