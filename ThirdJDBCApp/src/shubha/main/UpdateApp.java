package shubha.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

import shubha.utility.jdbcUtil;

public class UpdateApp {

	public static void main(String[] args) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement psmt=null;
		Scanner scanner=null;
		
		try {
			connection=jdbcUtil.getDbConnection();
				String sqlupdatequery="update student set sname=? where sid=?";
				if(connection!=null) {
				psmt=connection.prepareStatement(sqlupdatequery);
				
				if(psmt!=null) {
					scanner=new Scanner(System.in);
					System.out.println("Enter the value of sname:: ");
					String sname=scanner.next();
					
					System.out.println("Enter the value of sid :: ");
					int sid=scanner.nextInt();
					
					psmt.setString(1, sname);
					psmt.setInt(2, sid);
					
					
					int x=psmt.executeUpdate();
					if(x==1) {
						System.out.println("Updation Successfully !!");
					}else {
						System.out.println("No Updation is Successfully !!");
					}
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//closing the resources
			try {
				jdbcUtil.closeResouces(connection, psmt, resultSet);
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
