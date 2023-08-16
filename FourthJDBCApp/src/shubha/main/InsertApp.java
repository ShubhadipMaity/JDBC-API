package shubha.main;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import shubha.utility.jdbcUtil;

public class InsertApp {
	private static Statement statement;

	public static void main(String args []) {
		
		//Resources Used
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		
		try {
			//Getting the Connection
			
			connection=jdbcUtil.getDbConnection();
			String sqlInsertquery="insert into person(pname,dob) values(?,?)";
			if(connection!=null) {
			pstmt=connection.prepareStatement(sqlInsertquery);
			
			if(pstmt!=null) {
				 scanner=new Scanner(System.in);
				 
				 System.out.println("Enter the value of sname :");
				 String pname=scanner.next();
				
				System.out.println("Enter the value dob(dd-mm-yyyy):");
				String dob=scanner.next();
				
		//---------------------------------------------------------------------------------------------//
				//Date portion
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				
				Date utilDate = sdf.parse(dob);	
				
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());	
				
				
		//--------------------------------------------------------------------------------------------------//

	
				//setting the value for PreparedStatement
				
				pstmt.setString(1, pname);
				pstmt.setDate(2, sqlDate);
				
				
				
				int x=pstmt.executeUpdate();
				if(x==1) {
					System.out.println("Insertion Successfully !!");
				}else {
					System.out.println("Record is not Inserted in Database....");
				}
			}
			
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//closing the resources
			
			try {
				jdbcUtil.closeResources(resultSet, statement, connection);
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

