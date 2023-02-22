package patrol.controller;

import java.io.IOException;    
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patrol.dao.ReportDAO;
import patrol.model.Report;

/**
 * Servlet implementation class CreateResidentController
 */
@WebServlet("/CreateReports")
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
		r.setReportId(request.getParameter("reportId"));
		r.setPatrolmanId(request.getParameter("patrolmanId"));
		r.setReportDescription(request.getParameter("reportDescription"));
		r.setreportDateSubmit(request.getParameter("reportDateSubmit"));
		
		dao.addReport(r); //invoke method addShawl() in ShawlDAO
		
		request.setAttribute("report", ReportDAO.getReportDetails());
		RequestDispatcher view = request.getRequestDispatcher("pat viewReport.jsp"); //dia pergi mana lepas tu
		view.forward(request, response);
	}
}

