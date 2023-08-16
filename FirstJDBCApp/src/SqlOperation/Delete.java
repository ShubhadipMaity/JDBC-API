package SqlOperation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Delete {
	public static void main(String args []) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql:// localhost:3306/shubha";
		String user="root";
		String password="1234";
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
		Statement statement=connection.createStatement();
		
		String delectsqlquery=("delete from student where sid=2");
		int x=statement.executeUpdate(delectsqlquery);
		
		if(x==1) {
			System.out.println("No of row deleted is : "+x);
		}else {
			System.out.println("Not Successfully Delete Statement");
		}
		
		//close connection
		
		statement.close();
		connection.close();
		
	}

}
