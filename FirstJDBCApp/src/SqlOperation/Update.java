package SqlOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql:// localhost:3306/shubha";
		String user="root";
		String password="1234";
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
		Statement statement=connection.createStatement();
		
		String updatesqlquery=("update student set sid=2 where sage=18");
		
		int x=statement.executeUpdate(updatesqlquery);
		
		if(x==1) {
			System.out.println("No of updated row is :"+x);
		}else {
			System.out.println("Not update Successfully!!");
		}
		
		//Close connection
		
		statement.close();
		connection.close();

	}

}
