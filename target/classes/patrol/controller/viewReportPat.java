package patrol.controller;

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import patrol
import patrol.model.Report;
import patrol.dao.ReportDAO;

import java.io.IOException;

/**
 * Servlet implementation class viewSchedule
 */

@WebServlet("/ViewReportP")
public class viewReportPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewReportPat() {
        super();
        dao = new ReportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reportId = request.getParameter("reportId");
		request.setAttribute("report",ReportDAO.getReportDetail(reportId));
		RequestDispatcher view = request.getRequestDispatcher("res viewDetailReport.jsp");
		view.forward(request, response);
	}
}