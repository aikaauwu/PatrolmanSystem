package Servlet;

import java.io.*; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import DAO.ReportDAO;
import Model.Report;

/**
 * Servlet implementation class UpdateShawlController
 */
@WebServlet("/UpdateReportz")
public class UpdateReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReport() {
        super();
        dao = new ReportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reportId = (request.getParameter("reportId"));
		request.setAttribute("report", ReportDAO.getReportDetail(reportId));
		RequestDispatcher view = request.getRequestDispatcher("updateRep.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Report r = new Report();
		r.setReportId(request.getParameter("reportId"));
		r.setPatrolmanId(request.getParameter("patrolmanId"));
		r.setReportDescription(request.getParameter("reportDescription"));
		r.setreportDateSubmit(request.getParameter("reportDateSubmit"));
		
		dao.updateReport(r); 
		
		request.setAttribute("reports", ReportDAO.getReportDetails());
		RequestDispatcher view = request.getRequestDispatcher("HOMEPAGE PAT.jsp");
		view.forward(request, response);
	}
}