package DAO;

/**
 * Author: FES
 * Date: 15 January 2023
 * Purpose: CSC584 Assignment 2
 * Student name:
 * Student id:
 */
 
import java.sql.*;         
import java.util.*;
//import java.util.Date;

import Database.ConnectionManager;
//import Model.Resident;
import Model.scheduleModel;
import Database.ConnectionManager;


public class scheduleDao {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	//private static String sql;
	private String scheduleId;
	private String scheduleDate;
	private String patrolmanId;
	private String scheduleTime;
	private int locationId;
	
	public static scheduleModel getScheduleDetail(String scheduleId) { 
	    scheduleModel schedule = new scheduleModel();
	    try {
	      //call getConnection() method
	      con = ConnectionManager.getConnection();

	      
	      ps = con.prepareStatement("SELECT * FROM schedule WHERE scheduleId=?");
	      ps.setString(1, scheduleId);

	      //execute query
	    
	      
	      rs = ps.executeQuery();
	      if(rs.next()) {
	      schedule.setScheduleId(rs.getString("scheduleId"));
	      schedule.setPatrolmanId(rs.getString("patrolmanId"));
	      schedule.setScheduleTime(rs.getString("scheduleTime"));
	      schedule.setscheduleDate(rs.getString("scheduleDate"));
	      schedule.setLocationId(rs.getInt("locationId"));
	      
	      
	      //close connection
	      con.close();
	      }

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return schedule; 
	  }
	
	//Complete addOrder() method
	public void addSchedule(scheduleModel bean) {
		
		scheduleId = bean.getScheduleId();
		patrolmanId = bean.getPatrolmanId();

		scheduleDate = bean.getscheduleDate();

		scheduleTime = bean.getScheduleTime();
		locationId = bean.getLocationId();
		
	
		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection(); 
			
			//getting the number for the last schedule (last inserted schedule tu nombor berapa)
			 int trye = 0;
				ps = con.prepareStatement("SELECT schedulenum FROM schedule ORDER BY schedulenum DESC LIMIT 1");
		
			//executing the query
				rs = ps.executeQuery();
				
			//putting the number into a variable called "trye" 
				if(rs.next()) {
					trye = rs.getInt("schedulenum");}
					
			//setting the string part of the id, which should be start with "S"
			String depan = "";
				
			if (trye + 1 < 10)
			{
				depan = "S00";
			}
			
			else if (trye + 1 >=10 && trye<100)
			{
				depan = "S0";
			}
			
		
			int newtrye = trye + 1;
				
			String newid = depan + newtrye ;

			//create statement
						
			ps = con.prepareStatement("INSERT INTO schedule(schedulenum,scheduleid,patrolmanid,scheduletime,scheduledate,locationid)VALUES(?,?,?,?,?,?)");
			ps.setInt(1,newtrye);
			ps.setString(2,newid);
			ps.setString(3, patrolmanId);
			ps.setString(4, scheduleTime);
			ps.setString(5, scheduleDate);
			ps.setInt(6, locationId);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			//close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();				
		}
	}
	
	public static List<scheduleModel> getScheduleDetails() { 
		List<scheduleModel> schedule = new ArrayList<scheduleModel>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM schedule ORDER BY scheduleId";

			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				scheduleModel s = new scheduleModel();
				s.setScheduleId(rs.getString("scheduleId"));
				s.setPatrolmanId(rs.getString("patrolmanId"));
				s.setScheduleTime(rs.getString("scheduleTime"));
				s.setscheduleDate(rs.getString("scheduleDate"));
				s.setLocationId(rs.getInt("locationId"));
			
				schedule.add(s);
			}


			//close connection
			con.close();

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return schedule; 
	}
	
	public void deleteSchedule(String scheduleId) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//create statement 
			ps = con.prepareStatement("DELETE FROM schedule WHERE scheduleid=?");
			ps.setString(1, scheduleId);

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
