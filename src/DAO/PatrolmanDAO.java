package DAO;

import java.sql.*;   
import java.util.*;

import Database.ConnectionManager;
import Model.Patrolman;
import Model.Resident;

public class PatrolmanDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	//private static String sql;
	private String patrolmanId;
	private String residentId;
	//,patrolnum;
	private String patrolmanUsername,patrolmanPassword;
	private String login;

	
	//Complete addOrder() method
public void addPatrolman(Patrolman bean) {
		
		/*private String patrolmanId;
		private String residentId;
		private String patrolmanUsername,patrolmanPassword;
		*/
		
		//patrolnum = bean.getPatrolnum();
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
			
			//getting the number for the last patrolman (last inserted patrolman tu nombor berapa)
			 int trye = 0;
				ps = con.prepareStatement("SELECT patrolnum FROM patrolman ORDER BY patrolnum DESC LIMIT 1");
		
			//executing the query
				rs = ps.executeQuery();
				
			//putting the number into a variable called "trye" 
				if(rs.next()) {
					trye = rs.getInt("patrolnum");}
					
			//setting the string part of the id, which should be start with "P"
			String depan = "";
			
			if (trye + 1 < 10)
			{
				depan = "P00";
			}
			
			else if (trye + 1 >=10 && trye<100)
			{
				depan = "P0";
			}
			
		
			int newtrye = trye + 1;
			
			if (newtrye == 7) { newtrye = newtrye + 1; }
				
				
			String newid = depan + newtrye ;
				
			ps = con.prepareStatement("INSERT INTO patrolman(patrolnum,patrolmanId,residentId,patrolmanUsername,patrolmanPassword)VALUES(?,?,?,?,?)");
			ps.setInt(1, newtrye);
			ps.setString(2, newid);
			ps.setString(3, residentId);
			ps.setString(4, patrolmanUsername);
			ps.setString(5,patrolmanPassword);
			
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
			Patrolman patrolman2 = new Patrolman();
			 while(rs.next()) // Until next row is present otherwise it return false
	            {
				 patrolmanUsernameDB = rs.getString("patrolmanUsername"); //fetch the values present in database
				 patrolmanPasswordDB = rs.getString("patrolmanPassword");

	              if(patrolmanUsername.equals(patrolmanUsernameDB) && patrolmanPassword.equals(patrolmanPasswordDB))
	              {
	            	 patrolman2.setPatrolmanLoginUsername(rs.getString("patrolmanUsername"));
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
				s.setResidentId(rs.getString("residentId"));
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
	
	
	
	public static Patrolman getPatrolmanProfile(String patrolmanUsername) { 
		Patrolman patrolman = new Patrolman();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			
			ps = con.prepareStatement("SELECT * FROM patrolman WHERE patrolmanUsername=?");
			ps.setString(1, patrolmanUsername);

			//execute query
			
			rs = ps.executeQuery();
			if(rs.next()) {
				patrolman.setPatrolmanId(rs.getString("patrolmanId"));
				patrolman.setResidentId(rs.getString("residentId"));
				patrolman.setPatrolmanUsername(rs.getString("patrolmanUsername"));
				patrolman.setPatrolmanPassword(rs.getString("patrolmanPassword"));
				
			
			//close connection
			con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patrolman; 
	}
	
	public void updatePatrolman(Patrolman bean) {
	    
	      patrolmanId = bean.getPatrolmanId();
	      residentId = bean.getResidentId();
	      patrolmanUsername = bean.getPatrolmanUsername();
	      patrolmanPassword = bean.getPatrolmanPassword();
	  
	    try {      
	      //call getConnection() method
	      con = ConnectionManager.getConnection();
	      
	      //3. create statement
	      ps = con.prepareStatement("UPDATE patrolman SET patrolmanUsername=?, patrolmanPassword=? WHERE patrolmanId=?");
	      ps.setString(1, patrolmanUsername);
	      ps.setString(2, patrolmanPassword);
	      ps.setString(3, patrolmanId);
	      
	      //4. execute query
	      ps.executeUpdate();
	      
	      System.out.println("Successfully updated");
	      
	      //5. close connection
	      con.close();
	      
	    }catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	public static Resident getResidentProfile(String residentUsername) { 
		Resident resident = new Resident();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			
			ps = con.prepareStatement("SELECT * FROM resident WHERE residentUsername=?");
			ps.setString(1, residentUsername);

			//execute query
			
			/*rs = ps.executeQuery();
			if(rs.next()) {
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setBrand(rs.getString("brand"));
			s.setColor(rs.getString("color"));
			s.setMaterial(rs.getString("material"));
			s.setPrice(rs.getDouble("price"));
			s.setQuantity(rs.getInt("quantity"));			
			}
			
			
			order.setOrderId(rs.getInt("orderId"));
			order.setAmount(rs.getDouble("amount"));
			order.setSleeve(rs.getFloat("sleeve"));
			order.setShoulder(rs.getFloat("shoulder"));
			order.setChest(rs.getFloat("chest"));
			order.setTopLength(rs.getFloat("topLength"));
			order.setWaist(rs.getFloat("waist"));
			order.setHip(rs.getFloat("hip"));
			order.setBottomLength(rs.getFloat("bottomLength"));
			order.setCustomerId(rs.getInt("customerId"));*/
			
			//mybaju2
			
			/*private String residentId;
			private String residentUsername,residentPassword,residentName,residentAddress,residentEmail;
			private int residentPhoneNum;
			*/
			
			rs = ps.executeQuery();
			if(rs.next()) {
			resident.setResidentId(rs.getString("residentId"));
			resident.setResidentName(rs.getString("residentName"));
			resident.setResidentUsername(rs.getString("residentUsername"));
			resident.setResidentPassword(rs.getString("residentPassword"));
			resident.setResidentAddress(rs.getString("residentAddress"));
			resident.setResidentEmail(rs.getString("residentEmail"));
			resident.setResidentPhoneNum(rs.getInt("residentPhoneNum"));
			
			//close connection
			con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resident; 
	}
	}
	


