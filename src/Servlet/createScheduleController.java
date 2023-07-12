package Servlet;

import java.io.IOException;  
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.scheduleModel;

import DAO.scheduleDao;

/**
 * Servlet implementation class createScheduleController
 */
public class createScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private scheduleDao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createScheduleController() {
        super();
        dao = new scheduleDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 scheduleModel s = new scheduleModel();
		    //s.setScheduleId(request.getParameter("scheduleId"));
		    s.setPatrolmanId(request.getParameter("patrolmanId"));
		    s.setScheduleTime(request.getParameter("scheduleTime"));
		    s.setscheduleDate(request.getParameter("scheduleDate"));
		    s.setLocationId(Integer.parseInt(request.getParameter("locationId")));
		    
		    dao.addSchedule(s);
		    
		    request.setAttribute("schedules", scheduleDao.getScheduleDetails());
		    RequestDispatcher view = request.getRequestDispatcher("HOMEPAGE COM.jsp"); 
		    view.forward(request, response);
	}

}
