package patrol.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mybaju.connection.ConnectionManager;
import mybaju.model.Orders;

public class patrolmanDao {
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private int orderId;
	private Date dateCreated, dateCollect;
	private double amount;
	private float sleeve, shoulder, chest, topLength,waist, hip, bottomLength;
	private int customerId;

	public static patrolman getPatrolmanId(int patrolmanId) { 
		patrolman patrolmanid = new patrolman();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			ps = con.prepareStatement("SELECT * FROM orders WHERE orderId=?");
			ps.setInt(1, orderId);
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
			order.setOrderId(rs.getInt("orderId"));
			order.setDateCreated(rs.getDate("dateCreated"));
			order.setDateCollect(rs.getDate("dateCollect"));
			order.setAmount(rs.getDouble("amount"));
			order.setSleeve(rs.getFloat("sleeve"));
			order.setShoulder(rs.getFloat("shoulder"));
			order.setChest(rs.getFloat("chest"));
			order.setTopLength(rs.getFloat("topLength"));
			order.setWaist(rs.getFloat("waist"));
			order.setHip(rs.getFloat("hip"));
			order.setBottomLength(rs.getFloat("bottomLength"));
			order.setCustomerId(rs.getInt("customerId"));
		
			}

			//close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return order; 
	}
	
	
	
	
}
