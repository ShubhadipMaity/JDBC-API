package SqlOperation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestApp {
	public static void main(String[] args) throws ClassNotFoundException,
	SQLException {

	// load and register the driver
	// Class.forName("com.mysql.cj.jdbc.Driver");
		
	// Establish the Connection
	String url = "jdbc:mysql://localhost:3306/shubha";
	String user = "root";
	String password = "1234";

	Connection connection = DriverManager.getConnection(url, user,password);

	// Create a Statement object
	
	Statement statement = connection.createStatement();
	
	// Execute the query
	
	String sqlSelectQuery = "select * from student";
	ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
	
	System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
	
	// Process the resultSet

	while (resultSet.next()) {
	System.out.println(resultSet.getInt(1) + "\t" +resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t"+ resultSet.getString(4));
	}
	
	//close the resources
	
	resultSet.close();
	statement.close();
	connection.close();
	}
}
