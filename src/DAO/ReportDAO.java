package DAO;

import java.sql.*;  
import java.util.*;

import Database.ConnectionManager;
import Model.Report;
//import Model.*;

public class ReportDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	//private static String sql;
	private String reportId;
	private String patrolmanId, reportDescription, reportDateSubmit;
		//list
		public static Report getReportDetail(String reportId) { 
		Report r = new Report();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			ps = con.prepareStatement("SELECT * FROM report WHERE reportId=?");
			ps.setString(1, reportId);

			rs = ps.executeQuery();
			if(rs.next()) {
			r.setReportId(rs.getString("reportId"));
			r.setPatrolmanId(rs.getString("patrolmanId"));
			r.setReportDescription(rs.getString("reportDescription"));
			r.setreportDateSubmit(rs.getString("reportDateSubmit"));
			//close connection
			con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r; 
	}

		//createReport() method
		public void addReport(Report bean) {
		
		reportId = bean.getReportId();
		patrolmanId = bean.getPatrolmanId();
		reportDescription = bean.getReportDescription();
		reportDateSubmit = bean.getreportDateSubmit();

		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			

			//getting the number for the last patrolman (last inserted patrolman tu nombor berapa)
			 int trye = 0;
				ps = con.prepareStatement("SELECT reportnum FROM report ORDER BY reportnum DESC LIMIT 1");
		
			//executing the query
				rs = ps.executeQuery();
				
			//putting the number into a variable called "trye" 
				if(rs.next()) {
					trye = rs.getInt("reportnum");}
					
			//setting the string part of the id, which should be start with "RP"
			String depan = "";
				
			if (trye + 1 < 10)
			{
				depan = "RP00";
			}
			
			else if (trye + 1 >=10 && trye<100)
			{
				depan = "RP0";
			}
			
		
			int newtrye = trye + 1;
				
			String newid = depan + newtrye ;
			
			//create statement
			ps = con.prepareStatement("INSERT INTO report(reportnum,reportId, patrolmanId, reportDescription, reportDateSubmit) VALUES (?,?,?,?,?)");
			ps.setInt(1, newtrye);
			ps.setString(2,newid);
			ps.setString(3,patrolmanId);
			ps.setString(4,reportDescription);
			ps.setString(5,reportDateSubmit);

			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			//close connection
			con.close();

			} 
			
			catch(Exception e) {
			e.printStackTrace();				
			}
	}

	//Complete list method
		public static List<Report> getReportDetails() { 
			List<Report> report = new ArrayList<Report>(); 
			try { 
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//create statement
				stmt = con.createStatement();
				String sql = "SELECT * FROM report ORDER BY reportId";
				
			
				//execute query
				rs = stmt.executeQuery(sql);
					
					while(rs.next()) {		//process result
						Report r = new Report();
						r.setReportId(rs.getString("reportId"));
						r.setPatrolmanId(rs.getString("patrolmanId"));
						r.setReportDescription(rs.getString("reportDescription"));
						r.setreportDateSubmit(rs.getString("reportDateSubmit"));
						report.add(r);
						}
				//close connection
				con.close();

				} 
				catch (Exception e) 
				{ 
				e.printStackTrace(); 
				}
				return report; 
				}
	
		public void updateReport(Report bean) {
		
			reportId = bean.getReportId();
			patrolmanId = bean.getPatrolmanId();
			reportDescription = bean.getReportDescription();
			reportDateSubmit = bean.getreportDateSubmit();
	
		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE report SET reportDescription=?, reportDateSubmit=? WHERE reportId=?");
			ps.setString(1, reportDescription);
			ps.setString(2, reportDateSubmit);
			ps.setString(3, reportId);
			
			//4. execute query
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		public void deleteReport(String reportId) {
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();

				//create statement 
				ps = con.prepareStatement("DELETE FROM report WHERE reportId=?");
				ps.setString(1, reportId);

				//execute query
				ps.executeUpdate();

				//close connection
				con.close();

				}
			catch(Exception e) 
				{
				e.printStackTrace();
				}
			}
		
}
