package Servlet;

import javax.servlet.RequestDispatcher; 
import java.io.*;
//import java.nio.file.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;


import DAO.ReportDAO;

/**
 * Servlet implementation class ListShawlController
 */
@WebServlet("/ListReports")
public class ListReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ReportDAO dao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReport() {
        super();
       // dao = new ReportDAO();
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