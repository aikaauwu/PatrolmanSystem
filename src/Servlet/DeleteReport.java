package Servlet;

import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Report;
import DAO.ReportDAO;
/**
 * Servlet implementation class DeleteReport
 */
@WebServlet("/DeleteRepor")
public class DeleteReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO dao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReport() {
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
		dao.deleteReport(reportId);
		request.setAttribute("reports", ReportDAO.getReportDetails());
		RequestDispatcher view = request.getRequestDispatcher("ListReportPat");
		view.forward(request, response);
	}


}


