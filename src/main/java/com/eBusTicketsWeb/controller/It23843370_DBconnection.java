//IT23843370

package com.eBusTicketsWeb.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class It23843370_DBconnection {

	private static String url = "jdbc:mysql://127.0.0.1:3306/ebusticketsystem";
	private static String username = "root";
	private static String password = "";
	//private static Connection con;
	
	
	// Singleton instance of the connection
	private static Connection con = null;//single shared instance
	
	// Private constructor to prevent instantiation
    private It23843370_DBconnection() {}//only static Connection getConnection method can access
	
	public static Connection getConnection(){
		
		try {
			//only one instance of the connection is shared across application
			if(con == null || con.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");// updated to newer driver class
				con = DriverManager.getConnection(url,username,password);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return con;
		
		
	}
	
	
}
