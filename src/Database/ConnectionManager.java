package Database;

import java.sql.*;

public class ConnectionManager {
	private static Connection connect;
//	localhost Postgres database connection
//	private static final String DB_DRIVER = "org.postgresql.Driver";
//	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/academic_inventory";
//	private static final String DB_USERNAME = "postgres";
//	private static final String DB_PASSWORD = "system";
	
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-35-170-146-54.compute-1.amazonaws.com:5432/d7c5stchc9r4m2";
	private static final String DB_USERNAME = "yalefmpwdhspvx";
	private static final String DB_PASSWORD = "08c7d6ea111e36323c376646be202fa2326a7ca64ee31c36b786b8803efaf7d6";
	
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