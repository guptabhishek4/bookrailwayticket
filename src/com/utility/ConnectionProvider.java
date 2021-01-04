package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionProvider {

	static String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String userName="hr";
	static String pass="hr";
	

	public static Connection getConnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,userName,pass);
		return con;
	}
}
