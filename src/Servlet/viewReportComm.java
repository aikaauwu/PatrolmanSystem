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

//import Model.Report;

import DAO.ReportDAO;

/**
 * Servlet implementation class viewSchedule
 */

@WebServlet("/ViewReportCmm")
public class viewReportComm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ReportDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewReportComm() {
        super();
        //dao = new ReportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reportId = request.getParameter("reportId");
		request.setAttribute("report",ReportDAO.getReportDetail(reportId));
		RequestDispatcher view = request.getRequestDispatcher("comm viewDetailReport.jsp");
		view.forward(request, response);
	}
}