package Servlet;

import java.io.IOException;    
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ReportDAO;
import Model.Report;

/**
 * Servlet implementation class CreateResidentController
 */
@WebServlet("/CreateReportz")
public class CreateReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReportDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReport() {
        super();
        dao = new ReportDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Report r = new Report();
		//r.setReportId(request.getParameter("reportId"));
		r.setPatrolmanId(request.getParameter("patrolmanId"));
		r.setReportDescription(request.getParameter("reportDescription"));
		r.setreportDateSubmit(request.getParameter("reportDateSubmit"));
		
		dao.addReport(r); //invoke method addShawl() in ShawlDAO
		
		request.setAttribute("reports", ReportDAO.getReportDetails());
		RequestDispatcher view = request.getRequestDispatcher("HOMEPAGE PAT.jsp");
		view.forward(request, response);
	}
}
