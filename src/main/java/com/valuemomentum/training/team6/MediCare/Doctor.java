package com.valuemomentum.training.team6.MediCare;
 	import java.sql.*;
 	import java.sql.Connection;
 	import java.sql.PreparedStatement;
 	import java.sql.ResultSet;
 	import java.sql.Statement;
 	import java.util.Scanner;

 	public class Doctor {
 		Connection con;
 	    PreparedStatement stmt;
 	    ResultSet rs;
 	    Statement smt;
 	    Scanner s=new Scanner(System.in);

 	    void newDoctor() {
 	        try {
 	             
 	        	con=DbConnection.getConnection();
 	            
 	           
 	             System.out.println("Enter the Doctor id :");
 	             int a=s.nextInt();
 	             System.out.println("Enter the Doctor  first name:");
 	             String b=s.next();
 	      
 	             System.out.println("Enter the Doctor last name:");
 	             String c=s.next();
 	             System.out.println("Enter the Doctor date of joining:");
 	             String doj=s.next();
 	             System.out.println("Enter the Doctor Qualification");
 	             String d=s.next();
 	             System.out.println("Enter the Doctor mobile number:");
 	             String no=s.next();
 	             System.out.println("Enter the Doctor specialist:");
 	             String f=s.next();
 	             System.out.println("Enter the Doctor experience:");
 	             int g=s.nextInt();
 	             System.out.println("Enter the Doctor emailid:");
 	             String h=s.next();
 	             
 	             System.out.println("Enter the Doctor password:");
 	             String j=s.next();
 	             System.out.println("Enter the Doctor consultation fee:");
 	             int  fee=s.nextInt();
 	            
 	            stmt=con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?,?,?,?)");
 	             stmt.setInt(1,a);
 	             stmt.setString(2,b);
 	             stmt.setString(3,c);
 	             stmt.setString(4,doj);
 	             stmt.setString(5,d);
 	             stmt.setString(6,no);
 	             stmt.setString(7,f);
 	             stmt.setInt(8,g);
 	             stmt.setString(9,h);
 	             
 	             stmt.setString(10,j);
 	             stmt.setInt(11, fee);
 	             int i=stmt.executeUpdate();
 	             System.out.println("New Doctor details are added");
 	             System.out.println("      ");
 	          
 	        }
 	                          catch(Exception e){
 	              
 	               System.out.println(e);
 	               }
 	}
 	    void DeleteDoctor() {
 	        try {
 	              con=DbConnection.getConnection();
 	              System.out.println("Enter Doctor id:");
 	              int d_id=s.nextInt();
 	              String query="Delete from doctor where d_id=?";
 	              stmt=con.prepareStatement(query);
 	              stmt.setInt(1, d_id);
 	              int i=stmt.executeUpdate();
 	              System.out.println("Doctor details are deleted");
 	             System.out.println("           ");
 	       
 	    }
 	         catch(Exception e){
 	               
 	                System.out.println(e);
 	                }  
 	        
 	        
 	        
 	        
 	    }
 	    void ExistingDoctor() {
 	        try {
 	              con=DbConnection.getConnection();
 	              System.out.println("Enter Doctor id:");
 	              int id=s.nextInt();
 	              String query = "select d_id,fname,lname,doj,qualification,mobileno,specialist,experience,emailid,consultationfee from doctor where d_id = ?";
 	              stmt = con.prepareStatement(query);
 	              stmt.setInt(1, id);
 	              rs = stmt.executeQuery();
 	              
 	              while(rs.next()) {
 	// System.out.println("|Doctor's Id|Doctor's firstname|Doctor's last name|Doctor's doj|Doctor's qualification|Doctor's MobileNumber| Doctor's Specialist in|Doctor's Experience |Doctor's Emailid|Doctor's ConsultationFee");
 	  	               	
 	// System.out.println("|Doctor ID|   FirstName  | LastName   |        Doj    |    Qualification    |          MobileNumber    |        Specialist     |    Experience   |            EmailID               |   ConsultationFee");
 		
 	            	 System.out.println("|Doctor ID|   FirstName  | LastName   |        Doj    |    Qualification    |          MobileNumber    |        Specialist     |    Experience   |            EmailID               |   ConsultationFee");
 		String heading1=	"DoctorID";
 		String heading2=	"FirstName";
 		String heading3=	"LastName";
 		String heading4=	"Doj";
 		String heading5=	"Qualification"; 
 		String heading6=	"MobileNumber";//1,8,11
 		String heading7=	"Specialist";
 		String heading8=	"Experience";
 		//String heading8=	"MobileNumber";
 		String heading9=	"EmailID";
 		String heading10=	"ConsultationFee";
 		
 		
 	//	System.out.printf("%5d %17s %15s %15s %18s %18s %29s %15d %28s %20d\n",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));

 	/*System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"     " +rs.getString(3)+ "      "+rs.getString(4)+"    "
 	  	               	 		+rs.getString(5)+"   "+rs.getString(6)+"    "+rs.getString(7)+"  "+rs.getInt(8)+"   "+ rs.getString(9)+"   "+rs.getInt(10));*/
 	  	             
 		System.out.printf("%5d %15s %15s %15s %18s %23s %25s %20d %25s %18d\n",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
		  	
 	              }
 	              
 	              System.out.println("                 ");
 	              
 	              
 	             
 	        }
 	                catch(Exception e){
 	   
 	    System.out.println(e);
 	    }   
 	    }
 void displayDoctor() {
 	    
 	        	 try {
 		              con=DbConnection.getConnection(); 
 		              smt=con.createStatement();
 		  			//execute a query and retrieve the data into result set
 		  			rs=smt.executeQuery("select * from doctor");
 		  			
 		  			System.out.println("|Doctor ID|   FirstName  |   LastName   |        Doj    |    Qualification    |          MobileNumber    |        Specialist     |    Experience   |            EmailID               |   ConsultationFee");
 		  			while(rs.next())
 		  			{
 		  				

 						String heading1=	"DoctorID";
 		        		String heading2=	"FirstName";
 		        		String heading3=	"LastName";
 		        		String heading4=	"Doj";
 		        		String heading5=	"Qualification"; 
 		        		String heading6=	"MobileNumber";//1,8,11
 		        		String heading7=	"Specialist";
 		        		String heading8=	"Experience";
 		        		//String heading8=	"MobileNumber";
 		        		String heading9=	"EmailID";
 		        		String heading11=	"ConsultationFee";
 		        		
 		        		
 		        		System.out.printf("%5d %15s %15s %15s %18s %23s %25s %20d %25s %18d\n",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(11));
 		  		/*		System.out.println(rs.getInt(1)+"            " +rs.getString(2)+"                   "+rs.getString(3)+"             "
 		  			                        +rs.getString(4)+"               "+rs.getString(5)+"              "+rs.getString(6)+"  "
 		  			                        +rs.getString(7)+"                "+rs.getInt(8)+"                 "+rs.getString(9)+"  "+rs.getInt(10));
 		  			*/
 		        		System.out.println("     ");
 		        		}
 		  		
 		  			// System.out.println("*******************************************************************************************************************************************");
 		            System.out.println("     "); 
 		           System.out.println("     ");
 		  		}
 		  		catch(Exception e)
 		  		{
 		  			System.out.println(e);
 		  		}
 		  		
 	        }
 	
 	    
 	    void UpdateDetails() {
 	    	try {
 	    	con=DbConnection.getConnection();
 	    	System.out.println("Enter patient id for updation:");
 	    	int P_id=s.nextInt();
 	    	System.out.println("Enter the updated report:");
 	    	String update=s.next();
 	    	stmt  =con.prepareStatement( "update patients set reports=? where P_id = ?");
 	    	stmt.setString(1, update);
 	    	stmt.setInt(2, P_id);
 	    	int i=stmt.executeUpdate();
 	    	System.out.println("updated successfully");
 	    	System.out.println("   ");
 	    	}
 	    	catch(Exception e){
 	    	System.out.println(e);
 	    	}
 	    	}
 	}
