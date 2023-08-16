package SqlOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {      
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/shubha";
		String user="root";
		String password="1234";
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
		Statement statement=connection.createStatement();
		
		String sqlinsertquery="insert into student values(6,'Sohan',22,'MI')";
		int x=statement.executeUpdate(sqlinsertquery);
		
		if(x==1) {
			System.out.println("No of row affected is :"+x);
		}else {
			System.out.println("Not successfully in inserted");
		}
		
		//close the connection
		
		statement.close();
		connection.close();
	}

}
