package com.valuemomentum.training.team6.MediCare;

import java.sql.*;
import java.util.*;

public class login {
	Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement smt;
    int count;
    Scanner s=new Scanner(System.in);
	   
    int  DoctorLogin() 
	{
    	
		
		 

        String query1 = "select fname,emailid from doctor";
        System.out.println("Email-id:");
        String email_id1 = s.next();
        System.out.println("Password:");
        String password1 = s.next();
         count = 0;
        try {
            con = DbConnection.getConnection();
            smt = con.createStatement();
            rs = smt.executeQuery(query1);
         
            while (rs.next()) {
                String password = rs.getString(1);
                String emailid = rs.getString(2);
                
                if (email_id1.contentEquals(emailid) && password1.contentEquals(password)) {
                    count++;
                }
            }
            if(count==1) {
                System.out.println("Login Succesful");
            }
            else
            {
                System.out.println("Please enter the valid Email id or Password");
                
            }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
		
		return count;
    }

	 int StaffLogin() {
		        String query2 = "select fname,email_id from staff";
		        System.out.println("Email-id:");
		        String email_id2 = s.next();
		        System.out.println("Password:");
		        String password2 = s.next();
		        try {
		            con = DbConnection.getConnection();
		            smt = con.createStatement();
		            rs = smt.executeQuery(query2);
		            int count = 0;
		            while (rs.next()) {
		                String fname = rs.getString(1);
		                String email_id = rs.getString(2);
		                
		                if (email_id2.contentEquals(email_id) && password2.contentEquals(fname)) {
		                    count++;
		                }
		            }
		            if(count==1) {
		                System.out.println("Login Succesful");
		            }
		            else
		            {
		                System.out.println("Please enter the valid Email id or Password");
		            }
		            }
		        catch(Exception e) {
		            e.printStackTrace();
		        }
				return count;
		    }
	  int AdminLogin() 
		{
			 String query3 = "select fname,email_id from admin";
	        System.out.println("Email_id:");
	        String email_id3 = s.next();
	        System.out.println("Password:");
	        String password3 = s.next();
	        int count = 0;
	        try {
	            con = DbConnection.getConnection();
	            smt = con.createStatement();
	            rs = smt.executeQuery(query3);
	        
	            while (rs.next()) {
	                String password = rs.getString(1);
	                String email_id = rs.getString(2);
	                
	                if (email_id3.contentEquals(email_id) && password3.contentEquals(password)) {
	                    count++;
	                }
	            }
	            if(count==1) {
	                System.out.println("Login Succesful");
	                return count;
	            }
	            else
	            {
	                System.out.println("Please enter the valid Emailid or Password");
	            }
	            }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
			return count;
		
	    }

}
