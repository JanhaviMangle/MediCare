package com.valuemomentum.training.team6.MediCare;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	 static Connection con;
	public static Connection getConnection()
	{
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/medicare","root","Gudur@123");
		return con;
	}
	 catch(Exception e){ 
			
			System.out.println(e);
			return null;
			}  
	}
}
