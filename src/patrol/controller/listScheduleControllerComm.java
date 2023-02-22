package patrol.controller;

import jakarta.servlet.RequestDispatcher;
 
import jakarta.servlet.ServletException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import patrol.dao.scheduleDao;

/**
 * Servlet implementation class listScheduleController
 */
public class listScheduleControllerComm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private scheduleDao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listScheduleControllerComm() {
        super();
        dao = new scheduleDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String scheduleId = request.getParameter("scheduleId");
		request.setAttribute("schedules",scheduleDao.getScheduleDetails());
		RequestDispatcher view = request.getRequestDispatcher("comm viewSchedule.jsp");
		view.forward(request,  response);
	}



}
