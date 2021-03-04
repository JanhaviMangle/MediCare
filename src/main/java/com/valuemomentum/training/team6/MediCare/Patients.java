package com.valuemomentum.training.team6.MediCare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Patients {
	 Connection con;
	 PreparedStatement stmt;
     ResultSet rs;
     Statement smt;
     Scanner s=new Scanner(System.in);
    
     void newPatient() {
	        try {
	             
	        	con=DbConnection.getConnection();
	            
	           
	            // System.out.println("Enter the patient's id :\t");
	             //int a=s.nextInt();
	            
	             System.out.println("Enter the Patient FirstName:\t");
	             String b=s.next();
	      
	             System.out.println("Enter the Patient LastName:\t");
	             String c=s.next();
	             System.out.println("Enter the Patient Age:\t");
	             int age=s.nextInt();
	             System.out.println("Enter the patient Disease:\t");
	             String d=s.next();
	             System.out.println("Enter the Patient City:\t");
	             String e=s.next();
	             System.out.println("Enter the Patient Gender:\t");
	             String f=s.next();
	             System.out.println("Enter the patient Mobilenumber:");
	             String no=s.next();
	             System.out.println("Enter Doctor ID:");
	             int id=s.nextInt();
	           
	            System.out.println("enter EmailId");
	            String g=s.next();
	            System.out.println("enter Report Status");
	            String h=s.next();
	                      
	
	            
	             stmt=con.prepareStatement("insert into patients(fname,lname,age,disease,city,gender,mobileno,d_id,emailid,reports) values(?,?,?,?,?,?,?,?,?,?)");
	             
	            // stmt.setInt(1,a);
	             stmt.setString(1,b);
	             stmt.setString(2,c);
	             stmt.setInt(3,age);
	             stmt.setString(4,d);
	             stmt.setString(5,e);;
	             stmt.setString(6,f);
	             stmt.setString(7,no);
	             stmt.setInt(8, id);
	             stmt.setString(9, g);
	             stmt.setString(10, h);
	             
	             
	             int i=stmt.executeUpdate();//default method in ps
	             System.out.println("New patient details are inserted.");
	             System.out.println(" ");
	             System.out.println(" ");
	             
	          
	        }
	                           catch(Exception e){
	              
	               System.out.println(e);
	               }
	}
	    void ExistingPatients() {
			try {
				  con=DbConnection.getConnection();
				  System.out.println("Enter patient id:");
				  int P_id=s.nextInt();
				  String query = "select P_id,fname,lname,age,disease,city,gender,mobileno,d_id,emailid,reports from Patients where P_id = ?";
				  stmt = con.prepareStatement(query); 
				  stmt.setInt(1, P_id);
				  rs = stmt.executeQuery();
				  System.out.println("Patient   ID|      firstname     |	 lastname     |	   age      |	 disease         |	 city    |       Gender    |	 Mobile no     |   Doctor Id    |	  emailid      |	   Reports");

				  while(rs.next()) {
						String heading1=	"PatientID";
		        		String heading2=	"PatientFirstName";
		        		String heading3=	"PatientLastName";//149
		        		String heading4=	"Age";
		        		String heading5=	"Disease";
		        		String heading6=	"City";
		        		String heading7=	"Gender";
		        		String heading8=	"MobileNumber";
		        		String heading9=	"DoctorId";
		        		String heading10=	"EmailID";
		        		String heading11=	"Reports";
		        		
		        		//System.out.printf("%5d %16s %1s %23d %31s %25s %26s %21s %28d %25s %25s\n",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
		        
					  
//System.out.println("PatientID|Patient firstname|Patient lastname|Patient age|Patient disease|Patient city  |Patient Gender|Patient Mobile no|Doctor Id|Patient emailid |patient Reports");

System.out.printf("%5d %24s %18s %13d %20s %18s %17s %18s %15d %22s %22s\n",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));

//System.out.println(rs.getInt(1)+rs.getString(2)+"\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+
					                		//"\t"+rs.getString(5)+"\t"+rs.getString(6)+" \t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getInt(9)+"\t"+rs.getString(10)+rs.getString(12));

// System.out.println("Existing patient details are displayed");

					    }
				  System.out.println("     ");
				
				  
			}
	  			  catch(Exception e){ 
		
		System.out.println(e);
		}    
	}
	    
	    void DisplayPatient() {
	        try {
	              con=DbConnection.getConnection();
	              
	              smt=con.createStatement();
	  			
	  			//execute a query and retrieve the data into result set
	  			rs=smt.executeQuery("select P_id,fname,lname,age,disease,city,gender,mobileno,d_id,emailid,reports from patients");
	  			System.out.println("patient ID | 	FirstName	|  	LastName	 |        Age        |         Disease     |      City        |       Gender      |        MobileNumber  		| Doctor Id |                 EmailID           |      Reports ");

			  		
	  			
	  			while(rs.next())
	  			{
	  		//System.out.println("patients ID |Patient FirstName| 		Patient LastName |       Patient Age        |        Patient Disease     |      Patient City         |       Patient Gender       |       Patient MobileNumber  | Doctor Id |                Patient EmailID           | Patient Reports ");

	  		
			String heading1=	"PatientID";
 		String heading2=	"PatientFirstName";
 		String heading3=	"PatientLastName";
 		String heading4=	"Age";
 		String heading5=	"Disease";
 		String heading6=	"City";
 		String heading7=	"Gender";
 		String heading8=	"MobileNumber";
 		String heading9=	"DoctorId";
 		String heading10=	"EmailID";
 		String heading11=	"Reports";
 		
 		System.out.printf("%5d %16s %18s %23d %31s %20s %18s %21s %25d %25s %28s\n",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
 				//heading1,heading2,heading3,heading4,heading5,heading6,heading7,heading8,heading9,heading10,heading11);
 	/*rs.getInt(1)+" "+rs.getString(2)+"   "+rs.getString(3)+"  "
	  			                        +rs.getInt(4)+"  "+rs.getString(5)+"   "+rs.getString(6)+"  "
	  			                        +rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getInt(9)+"  "+rs.getString(10)+"  "+rs.getString(11));*/
	  			
	  			System.out.println("         ");
	  			} 
	  		}
	  		catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  		
	              
	       
	    }
	         
	    
	   
	    
	    void DeletePatient() {
	        try {
	              con=DbConnection.getConnection();
	              System.out.println("Enter patient  id:");
	              int P_id=s.nextInt();
	              String query="Delete  from patients where P_id=?";
	              stmt=con.prepareStatement(query);
	              stmt.setInt(1, P_id);
	              int i1=stmt.executeUpdate();
	              System.out.println("Patient details are deleted");
	             System.out.println("     ");
	       
	    }
	         catch(Exception e){
	               
	                System.out.println(e);
	                }   
	    }
	    
	    
	    
	    /*void BookAnAppointment() {
	        System.out.println("****************Book an appointment*********************");
	        System.out.println("Enter your disease:");
	        String dieases=s.next();
	        try
	        {
	            con=DBConnection.getConnection();
	            String query = "select fname,lname,qualification,mobileno,specialist from doctor where specialist= ?";
	            stmt = con.prepareStatement(query);
	              stmt.setString(1,dieases);
	              rs = stmt.executeQuery();
	              while(rs.next())
	              {
	               System.out.println("|Doctor's firstname|Doctor's last name|Doctor's qualification|"
	               		+ "Doctor's MobileNumber| Doctor's Specialist in |Doctor's Emailid");
	               	 System.out.println(rs.getString(1)+"     " +rs.getString(2)+ "      "+rs.getString(3)+"    "
	               	 		+rs.getString(4)+"   "+rs.getString(5)+"      "+rs.getString(6));
	              }
	           
	        }
	        catch(Exception e){
	           
	            System.out.println(e);
	            }   
	               
	        System.out.println("Enter the date and time");
	        String d=s.next();
	        String t=s.next();
	        System.out.println("Your appointment is booked on "+d+" at "+t);
	    }*/
	        
	       



		
	}
	
	

