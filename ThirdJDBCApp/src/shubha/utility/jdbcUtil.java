package shubha.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {
	
		// load register the Driver 
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDbConnection() throws SQLException {
		
		//Establish the Connection
		
		String url="jdbc:mysql:// localhost:3306/shubha";
		String user="root";
		String password="1234";
		return DriverManager.getConnection(url,user,password);
		
	}
	
	public static void closeResouces(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {
		
		// Connection Close ----This is an Block Of Code-------
		
		if(connection!=null)
			connection.close();
		if(statement!=null)
			statement.close();
		if(resultSet!=null)
			resultSet.close();
	}
	
}
