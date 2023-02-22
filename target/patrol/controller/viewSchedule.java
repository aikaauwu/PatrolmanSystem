package patrol.controller;

import jakarta.servlet.RequestDispatcher;  
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import patrol.model.scheduleModel;
import patrol.dao.scheduleDao;
import java.io.IOException;

/**
 * Servlet implementation class viewSchedule
 */
public class viewSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private scheduleDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewSchedule() {
        super();
        dao = new scheduleDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String scheduleId = request.getParameter("scheduleId");
		request.setAttribute("schedule",scheduleDao.getScheduleDetail());
		RequestDispatcher view = request.getRequestDispatcher("viewDetailSchedule.jsp"); //schedule page
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
