package com.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
	
public static Connection createConnection() throws ClassNotFoundException, SQLException
{
	System.out.println("Connection Call");
	
	Connection con = null;
	String url="jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_bb73c99d4900b21";
	String username ="b3b0c0f7e4a1ea";
	String password="14e9fb76";
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriveManager.getConnection(url,username,password);
	return con;
}
}
