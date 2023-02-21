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
import patrol.model.Patrolman;
import patrol.model.Resident;

public class PatrolmanDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private String patrolmanId;
	private int residentId;
	private String patrolmanUsername,patrolmanPassword;

	//Complete addOrder() method
	public void addPatrolman(Patrolman bean) {
		
		/*private String patrolmanId;
		private String residentId;
		private String patrolmanUsername,patrolmanPassword;
		*/
		
		patrolmanId = bean.getPatrolmanId();
		residentId = bean.getResidentId();
		patrolmanUsername = bean.getPatrolmanUsername();
		patrolmanPassword = bean.getPatrolmanPassword();
		

		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			/*patrolmanId = bean.getPatrolmanId();
			residentId = bean.getResidentId();
			patrolmanUsername = bean.getPatrolmanUsername();
			patrolmanPassword = bean.getPatrolmanPassword();
			*/
			
			ps = con.prepareStatement("INSERT INTO patrolman(patrolmanId,residentId,patrolmanUsername,patrolmanPassword)VALUES(?,?,?)");
			ps.setString(1, patrolmanId);
			ps.setInt(2, residentId);
			ps.setString(2, patrolmanUsername);
			ps.setString(3,patrolmanPassword);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			//close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();				
		}
	}	
	
	public String authenticateUser(Patrolman patrolman)
    {
	
		/* String studUsername = student.getStudUsername();
        String studPassword = student.getStudPassword(); //Assign user entered values to temporary variables.
        
        String studUsernameDB = "";
        String studPasswordDB = "";

		 */
		
		String patrolmanUsername = patrolman.getPatrolmanUsername();
		String patrolmanPassword = patrolman.getPatrolmanPassword();
		
		String patrolmanUsernameDB = "";
		String patrolmanPasswordDB = "";
		
        try
        {
    
        	//con = ConnectionManagerStud.getConnection();
        	
        	con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "select * from patrolman";

			
			//execute query
			rs = stmt.executeQuery(sql);
			
           // table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

           /* while(rs.next()) // Until next row is present otherwise it return false
            {
             studUsernameDB = rs.getString("studUsername"); //fetch the values present in database
             studPasswordDB = rs.getString("studPassword");

              if(studUsername.equals(studUsernameDB) && studPassword.equals(studPasswordDB))
              {
                 return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
              }
            }}
            catch(SQLException e)
            {
               e.printStackTrace();
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure
        }
        */
			
			 while(rs.next()) // Until next row is present otherwise it return false
	            {
				 patrolmanUsernameDB = rs.getString("patrolmanUsername"); //fetch the values present in database
				 patrolmanPasswordDB = rs.getString("patrolmanPassword");

	              if(patrolmanUsername.equals(patrolmanUsernameDB) && patrolmanPassword.equals(patrolmanPasswordDB))
	              {
	                 return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
	              }
	            }}
	            catch(SQLException e)
	            {
	               e.printStackTrace();
	            }
	            return "Invalid user credentials"; // Return appropriate message in case of failure
	        }
	
//complete getpatrolmanId() method
	public static List<Patrolman> getPatrolmanDetails(){
		List<Patrolman> patrolman = new ArrayList<Patrolman>();
		try {
			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM patrolman ORDER BY patrolmanId";
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Patrolman s = new Patrolman();
				s.setPatrolmanId(rs.getString("patrolmanId"));
				s.setResidentId(rs.getInt("residentId"));
				s.setPatrolmanUsername(rs.getString("patrolmanUsername"));
				s.setPatrolmanPassword(rs.getString("patrolmanPassword"));
				
				patrolman.add(s);
			}
			
			//close connection
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return patrolman;
		}
	}
	


