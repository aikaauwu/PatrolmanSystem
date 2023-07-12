package Servlet;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



import DAO.ReportDAO;

/**
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListReportP")
public class ListReportPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ReportDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReportPat() {
        super();
       // dao = new ReportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patrolmanUsername = request.getParameter("patrolmanUsername");
		request.setAttribute("reports", ReportDAO.getReportDetails());
		RequestDispatcher view = request.getRequestDispatcher("pat viewReport.jsp");
		view.forward(request, response);
	}
}