package patrol.connection;

import java.sql.*;

public class ConnectionManager {
	private static Connection connect;
//	localhost Postgres database connection
//	private static final String DB_DRIVER = "org.postgresql.Driver";
//	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/academic_inventory";
//	private static final String DB_USERNAME = "postgres";
//	private static final String DB_PASSWORD = "system";
	
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-3-227-68-43.compute-1.amazonaws.com:5432/d2cm8tatb0l79l";
	private static final String DB_USERNAME = "yadcxethtlqosn";
	private static final String DB_PASSWORD = "20fdd8e07a709fae226a7c685df595d7162d04f8dd1081f731b3639b29ad334b";
	
	public static Connection getConnection() {
		try {
			Class.forName(DB_DRIVER);
			try {
				connect = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
				System.out.println("Connection Success");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
	}
}