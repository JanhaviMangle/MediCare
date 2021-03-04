package com.valuemomentum.training.team6.MediCare;

import java.sql.*;
import java.util.*;

public class Bill {
	
	Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement smt;
    Scanner s=new Scanner(System.in);
    
    void newBill() {
    	try {
    	con=DbConnection.getConnection();
    	System.out.println("Enter Patient Id for  bill:");
    	int Pid=s.nextInt();
    	
    	System.out.println("Enter consultation fee of patient:");
    	int of=s.nextInt();
    	
    	System.out.println("Enter no of days that patient have been admitted:");
    	int days=s.nextInt();
    
    	System.out.println("Enter name of the Diagnostic test:");
    	String dt=s.next();
    	
    	System.out.println("Enter scanning fee of Patient");
    	int scan=s.nextInt();
    	
    	
    	stmt  =con.prepareStatement("insert into consultation values(?,?,?,?,?)");
    			
    	stmt.setInt(1,Pid);
        stmt.setInt(2,of );
    	stmt.setInt(3, days);
    	stmt.setString(4, dt);
    	
    	stmt.setInt(5, scan);
    	
    	
    	int i=stmt.executeUpdate();
    	System.out.println(" New patient's bill added");
    	System.out.println("     ");
    	}
    	catch(Exception e){
        	System.out.println(e);
        	}
        }
    
    
    void UpdateBill() {
    	try {
    	con=DbConnection.getConnection();
    	System.out.println("Enter patient id for updating bill:");
    	int Pid=s.nextInt();
    	System.out.println("Enter no of days that patient have been admitted:");
    	int days=s.nextInt();
    	System.out.println("Enter consultation fee of patient:");
    	int of=s.nextInt();
    	System.out.println("Enter the name of diagnostic test:");
    	String dt=s.next();
    	
    	System.out.println("Enter scanning fee of patient");
    	int scan=s.nextInt();
    	
    	
    	stmt  =con.prepareStatement( "UPDATE consultation SET Outfee=?,NoofDays=?,diagnostictests=?,Scanfee=? WHERE Pid=?");
    			
    	
    	stmt.setInt(1,of );
    	stmt.setInt(2, days);
    	stmt.setString(3, dt);
    	
    	stmt.setInt(4, scan);
    	stmt.setInt(5,Pid);
    	
    	int i=stmt.executeUpdate();
    	System.out.println("updated bill successfully");
    	System.out.println(" ");
    	}
    	catch(Exception e){
    	System.out.println(e);
    	}
    }
    
    void DeleteBill() {
        try {
              con=DbConnection.getConnection();
              System.out.println("Enter patient  id:");
              int Pid=s.nextInt();
              String query="Delete  from consultation where Pid=?";
              stmt=con.prepareStatement(query);
              stmt.setInt(1, Pid);
              int i1=stmt.executeUpdate();
              System.out.println("Patient bill details are deleted");
              System.out.println(" ");
             
       
    }
         catch(Exception e){
               
                System.out.println(e);
                }   
    }
   
    
    void printBill()
    {
    	 try {
             con=DbConnection.getConnection();
             System.out.println("Enter patient id:");
             int id=s.nextInt();
             String query = "select Pid,Outfee,NoofDays,Scanfee,(NoofDays*Outfee)+Scanfee as Totalbill from consultation where Pid = ?";
             stmt = con.prepareStatement(query);
             stmt.setInt(1, id);
             rs = stmt.executeQuery();
             while(rs.next()) {
            	 
            	// System.out.println("Patient Id   | 	Consultation  Fee  |	NO  of   Days	 |	 Scanfee 	| Total bill |");
            	 
            	// System.out.println("|Doctor ID|   FirstName  | LastName   |        Doj    |    Qualification    |          MobileNumber    |        Specialist     |    Experience   |            EmailID               |   ConsultationFee");
	  				

					String heading1=	"Patient Id ";
	        		String heading2=	"Patient Out fee ";
	        		String heading3=	"NO  of   Days";
	        		String heading4=	"Patient Scanfee ";
	        		String heading5=	"Patient Total bill"; 
	        		//String heading6=	"MobileNumber";//1,8,11
	        		//String heading7=	"Specialist";
	        		//String heading8=	"Experience";
	        		//String heading8=	"MobileNumber";
	        		//String heading9=	"EmailID";
	        		//String heading11=	"ConsultationFee";
	        		
	        		System.out.println("Patient Id: "+rs.getInt(1)+"\t Consultation fee: "+rs.getInt(2)+"\t No of Days: "+rs.getInt(3)+"\t Diagnostics Test Fee: "+rs.getInt(4)+"\n \n Total bill:"+rs.getInt(5));
	        	//	System.out.printf("%5d %15d %15d %15d %18d \n",rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getInt(4),rs.getInt(5));
	  

                // System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+" "+rs.getInt(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
             }
            
       }
               catch(Exception e){
  
   System.out.println(e);
   }   
  
    }
    	
    	


}
