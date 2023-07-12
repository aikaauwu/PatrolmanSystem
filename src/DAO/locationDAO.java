package DAO;

import java.sql.*;  
import java.util.*;

import Database.ConnectionManager;
import Model.Location;
//import Model.Patrolman;
import DAO.locationDAO;



public class locationDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	//private static String sql;
	//private String locatianArea;
	//private int locationId;
	//private String locationAddress;
	
	public static Location getLocationDetail(int locationId) { 
	    Location locations = new Location();
	    try {
	      //call getConnection() method
	      con = ConnectionManager.getConnection();

	      
	      ps = con.prepareStatement("SELECT * FROM location WHERE locationId=?");
	      ps.setInt(1, locationId);

	      //execute query
	      
	      rs = ps.executeQuery();
	      if(rs.next()) {
	        locations.setLocationId(rs.getInt("locationId"));
	        locations.setLocationArea(rs.getString("locationArea"));
	        locations.setLocationAddress(rs.getString("locationAddress"));
	        
	        
	      
	      //close connection
	      con.close();
	      }

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return locations; 
	  }
	

	
	public static List<Location> getLocationDetails() { 
		List<Location> locations = new ArrayList<Location>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM location ORDER BY locationId";

			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Location location2 = new Location();
				location2.setLocationId(rs.getInt("locationId"));
				location2.setLocationArea(rs.getString("locationArea"));
				location2.setLocationAddress(rs.getString("locationAddress"));
				locations.add(location2);
			}


			//close connection
			con.close();

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return locations; 
	}
	

	

}
