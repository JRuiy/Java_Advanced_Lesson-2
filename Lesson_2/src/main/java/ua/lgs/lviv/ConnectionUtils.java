package ua.lgs.lviv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	private static String USER_NAME = "vadim";
	private static String USER_PASSWORD = "123456";
	private static String URL = "jdbc:mysql://localhost/internet_shop";
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
	
	
}
