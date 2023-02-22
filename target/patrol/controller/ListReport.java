package patrol.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patrol.dao.ReportDAO; 

/**
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListReports")
public class ListReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReport() {
        super();
        dao = new ReportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("reports", ReportDAO.getReportDetails());
		RequestDispatcher view = request.getRequestDispatcher("res viewReport.jsp");
		view.forward(request, response);
	}
}