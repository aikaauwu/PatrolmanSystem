package patrol.controller;
 
import java.io.IOException;      
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
import patrol.model.Resident;
import patrol.dao.ResidentDAO;
 
public class LoginResidentServlet extends HttpServlet {
 
    public LoginResidentServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
    	String residentUsername = request.getParameter("residentUsername");
    	String residentPassword = request.getParameter("residentPassword");
    	
    	Resident resident = new Resident(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
    	//meow 
    	
    	resident.setResidentUsername(residentUsername);
    	resident.setResidentPassword(residentPassword);
    	
    	ResidentDAO loginDao = new ResidentDAO();
     
        String userValidate = loginDao.authenticateUser(resident); //Calling authenticateUser function
 
        if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
         {
             request.setAttribute("residentUsername", residentUsername); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.getRequestDispatcher("/HOMEPAGE RESIDENTS.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page (aka dia pi mana lepas log in)
         }
         else
         {
             request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getRequestDispatcher("/index.jsp").forward(request, response);//forwarding the request
         }
    }
}
