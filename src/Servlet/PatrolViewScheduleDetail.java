package Servlet;

import java.io.IOException;   
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

//import Model.scheduleModel;

import DAO.scheduleDao;
/**
 * Servlet implementation class viewSchedule
 */
@WebServlet("/PatrolViewScheduleDetails")
public class PatrolViewScheduleDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
//private scheduleDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatrolViewScheduleDetail() {
        super();
       // dao = new scheduleDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String scheduleId = request.getParameter("scheduleId");
		request.setAttribute("schedule",scheduleDao.getScheduleDetail(scheduleId));
		RequestDispatcher view = request.getRequestDispatcher("pat viewScheduleDetail.jsp"); //schedule page
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
