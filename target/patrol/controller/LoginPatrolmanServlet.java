package patrol.controller;
 
import java.io.IOException;       
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
import patrol.model.Patrolman;
import patrol.dao.PatrolmanDAO;
 
public class LoginPatrolmanServlet extends HttpServlet {
 
    public LoginPatrolmanServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
    	String patrolmanUsername = request.getParameter("patrolmanUsername");
    	String patrolmanPassword = request.getParameter("patrolmanPassword");
    	
    	Patrolman patrolman = new Patrolman(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
    	//meow 
    	
    	patrolman.setPatrolmanUsername(patrolmanUsername);
    	patrolman.setPatrolmanPassword(patrolmanPassword);
    	
    	PatrolmanDAO loginCommDao = new PatrolmanDAO();
     
        String userValidate = loginCommDao.authenticateUser(patrolman); //Calling authenticateUser function
 
        if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
         {
             request.setAttribute("patrolmanUsername", patrolmanUsername); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.getRequestDispatcher("/HOMEPAGE PAT.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page (aka dia pi mana lepas log in)
         }
         else
         {
             request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getRequestDispatcher("/login patrolman.jsp").forward(request, response);//forwarding the request
         }
    }
}