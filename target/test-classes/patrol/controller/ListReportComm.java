package patrol.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import patrol.dao.ReportDAO; 

/**
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListReporm")
public class ListReportComm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReportComm() {
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