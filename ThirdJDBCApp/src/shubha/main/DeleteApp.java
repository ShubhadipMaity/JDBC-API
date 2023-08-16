package shubha.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import shubha.utility.jdbcUtil;

public class DeleteApp {

	public static void main(String[] args) {
		
		//Use Resources
		
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement psmt=null;
		Scanner sc=null;
		
		try {
			connection=jdbcUtil.getDbConnection();
			String sqlUpdatequery="delete from student where sid=?";
			if(connection!=null) {
				psmt=connection.prepareStatement(sqlUpdatequery);
				
				if(psmt!=null) {
					sc=new Scanner(System.in);
					System.out.println("Enter the value of sid :: ");
					int sid=sc.nextInt();
					
					psmt.setInt(1, sid);
					
					int x=psmt.executeUpdate();
					if(x==1) {
						System.out.println("Updation is Successfully !!");
					}else {
						System.out.println("No Updation is here !!");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Closing the resources 
			
			try {
				jdbcUtil.closeResouces(connection, psmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
