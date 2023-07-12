package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.scheduleModel;
import DAO.scheduleDao;
/**
 * Servlet implementation class CommDeleteScheduleController
 */
@WebServlet("/CommDeleteScheduleControlle")
public class CommDeleteScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private scheduleDao dao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommDeleteScheduleController() {
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
		dao.deleteSchedule(scheduleId);
		request.setAttribute("schedules", scheduleDao.getScheduleDetails());
		RequestDispatcher view = request.getRequestDispatcher("listScheduleControllerComm");
		view.forward(request, response);
	}


}


