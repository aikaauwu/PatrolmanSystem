package patrol.dao;

/**
 * Author: FES
 * Date: 15 January 2023
 * Purpose: CSC584 Assignment 2
 * Student name:
 * Student id:
 */
 
import java.sql.*;      
import java.util.*;
import java.util.Date;

import patrol.connection.ConnectionManager;
import patrol.model.scheduleModel;


public class scheduleDao {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private String scheduleId;
	private String dateCreated;
	private String patrolmanId;
	private String scheduleTime;
	private String locationId;
	
	//Complete addOrder() method
	public void addSchedule(scheduleModel bean) {
		
		scheduleId = bean.getScheduleId();
		patrolmanId = bean.getPatrolmanId();
		dateCreated = bean.getDateCreated();
		scheduleTime = bean.getScheduleTime();
		locationId = bean.getLocationId();
	

		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection(); 

			//create statement
						
			ps = con.prepareStatement("INSERT INTO schedule(scheduleId,patrolmanId,scheduleTime,dateCreated,locationId)VALUES(?,?,?,?,?)");
			ps.setString(1, scheduleId);
			ps.setString(2, patrolmanId);
			ps.setString(3, scheduleTime);
			ps.setString(4, dateCreated);
			ps.setString(5, locationId);
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
		List<scheduleModel> schedules = new ArrayList<scheduleModel>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM schedule BY scheduleId";

			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				scheduleModel schedule = new scheduleModel();
				schedule.setScheduleId(rs.getString("scheduleId"));
				schedule.setPatrolmanId(rs.getString("patrolmanId"));
				schedule.setScheduleTime(rs.getString("scheduleTime"));
				schedule.setDateCreated(rs.getString("dateCreated"));
				schedule.setLocationId(rs.getString("locationId"));
			
				schedules.add(schedule);
			}


			//close connection
			con.close();

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return schedules; 
	}

	

}
