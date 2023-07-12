package DAO;

/**
 * Author: FES  
 * Date: 15 January 2023
 * Purpose: CSC584 Assignment 2
 * Student name:
 * Student id:
 */
  
import java.sql.*;         
//import java.util.*;
//import java.util.Date;


import Database.ConnectionManager;
import Model.Committee;
//import Model.*;

public class LoginCommDAO {
	private static Connection con = null;
	//private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	//private static String sql;
	//private String commID;
	//private String commUsername,commPassword,commPosition;
	

	public String authenticateUser(Committee committee)
    {
	
		String commUsername = committee.getCommUsername();
		String commPassword = committee.getCommPassword();
		
		String commUsernameDB = "";
		String commPasswordDB = "";
		
        try
        {
    
        	//con = ConnectionManagerStud.getConnection();
        	
        	con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "select * from committee";

			
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
	             commUsernameDB = rs.getString("commUsername"); //fetch the values present in database
	             commPasswordDB = rs.getString("commPassword");

	              if(commUsername.equals(commUsernameDB) && commPassword.equals(commPasswordDB))
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
	

}