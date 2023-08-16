package shubha.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import shubha.utility.jdbcUtil;

public class SelectionApp {

	public static void main(String[] args) {
		Connection connection=null;
		ResultSet resultset=null;
		PreparedStatement psmt=null;
		Scanner sc=null;
		String pname=null;
		
		try {
			connection=jdbcUtil.getDbConnection();
			String sqlSelectquery="select * from person where pname=?";
			if(connection!=null) {
				psmt=connection.prepareStatement(sqlSelectquery);
				
				if(psmt!=null) {
					sc=new Scanner(System.in);
					
					System.out.println("Enter the value of pname ::  ");
					 pname=sc.next();
					
					
					
					
					
					//setting the value for PreparedStatement
					
					psmt.setString(1, pname);
					resultset=psmt.executeQuery();
					if(resultset!=null) {
						if(resultset.next()) {
							System.out.println("PNAME\tDOB");
							Date sqlDate=resultset.getDate(2);
							
							SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
							
							String stringDate=sdf.format(sqlDate);
							
							
							System.out.println(resultset.getString(1)+"\t"+stringDate);
						}else {
							System.out.println("Record not available for the give name :: "+pname);
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close Resources
			try {
			jdbcUtil.closeResources(resultset, psmt, connection);
			sc.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
