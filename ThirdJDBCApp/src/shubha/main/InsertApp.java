package shubha.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import shubha.utility.jdbcUtil;

public class InsertApp {
	public static void main(String args []) {
		
		//Resources Used
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		
		try {
			//Getting the Connection
			
			connection=jdbcUtil.getDbConnection();
			String sqlInsertquery="insert into student(sid,sname,sage,saddress) values(?,?,?,?)";
			if(connection!=null) {
			pstmt=connection.prepareStatement(sqlInsertquery);
			
			if(pstmt!=null) {
				 scanner=new Scanner(System.in);
				 
				 System.out.println("Enter the value of sname :");
				 String sname=scanner.next();
				
				System.out.println("Enter the value of sid :");
				int sid=scanner.nextInt();
				
				
				System.out.println("Enter the value of saddress :");
				String saddress=scanner.next();
				
				
				System.out.println("Enter the value of sage :");
				int sage=scanner.nextInt();
				
			
				
				//setting the value for PreparedStatement
				
				pstmt.setInt(1, sid);
				pstmt.setString(2, sname);
				pstmt.setInt(3, sage);
				pstmt.setString(4, saddress);
				
				
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
				jdbcUtil.closeResouces(connection, pstmt, resultSet);
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
