package shubha.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import shubha.utility.jdbcUtil;

public class SelectionApp {

	public static void main(String[] args) {
		
		
		//  Resourced Used
		
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement psmt=null;
		Scanner sc=null;
		Integer sid=null;
		
		try {
			String sqlselectQuery="select * from student where sid=?";
			connection=jdbcUtil.getDbConnection();
			psmt=connection.prepareStatement(sqlselectQuery);
			
			if(psmt!=null) {
				sc=new Scanner(System.in);
				
				System.out.println("Enter the value of sid :: ");
				 sid=sc.nextInt();
				
				psmt.setInt(1, sid);
				
				resultSet=psmt.executeQuery();
				
				if(resultSet!=null) {
					System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
				if(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
				}else {
					System.out.println("Record not available for the give sid :: "+sid);
				}
			}		
	}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
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
