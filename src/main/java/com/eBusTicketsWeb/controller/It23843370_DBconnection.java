//IT23843370

package com.eBusTicketsWeb.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class It23843370_DBconnection {

	private static String url = "jdbc:mysql://127.0.0.1:3306/ebusticketsystem";
	private static String username = "root";
	private static String password = "";
	private static Connection con;
	
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return con;
		
		
	}
	
	
}
