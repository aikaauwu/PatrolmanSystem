package patrol.controller;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import patrol
import patrol.model.Report;
import patrol.dao.ReportDAO;

import java.io.IOException;

/**
 * Servlet implementation class viewSchedule
 */

@WebServlet("/ViewReports")
public class viewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewReport() {
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