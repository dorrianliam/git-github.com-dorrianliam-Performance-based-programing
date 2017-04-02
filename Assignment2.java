package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment2 
{

	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/user_details";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	   Connection conn = null;
	   Statement stmt = null;
	   Scanner kb = new Scanner(System.in);
	   Stopwatch stopStackInser = new Stopwatch();
	   String sql = null;
	 
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      System.out.println("Connected database successfully...");
	      
	 
     //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      
	     
	     
	      stmt = conn.createStatement();
	      
	
	
	
	 System.out.println("#### Options#######");
	 System.out.println("1)Add records");
	 System.out.println("2)delete records");
	 System.out.println("3)update records");
	 System.out.println("4)view records");
	 System.out.println("5)Exit");
	 
	 System.out.print("please eneter record");
	  int option=kb.nextInt();
	
	
	
	switch(option)
	{
	  
	case 1:
		
	  System.out.print("Enter firstname");
	  kb.nextLine();
	  String fname =kb.nextLine();
	  System.out.print("Enter usertname");
	  String uname =kb.nextLine();
	  
	 stopStackInser.start();
   
	 sql="insert into user_details values( "+0+" , ' "+fname+" ', ' "+uname+" ' )";
	 
	 stmt.execute(sql);
   
    System.out.println("Time Taken "+stopStackInser.getElapsedTime());
    stopStackInser.reset();
    
  
	  break;
	    
		
			
		
	case 2:
	
		System.out.print("Enter id to delete");
		 int id =kb.nextInt();
		 
		 stopStackInser.start();
		
		sql = "DELETE FROM user_details WHERE user_id = "+id;
		   stmt.executeUpdate(sql);
	   
	      
	      stopStackInser.stop();
	      System.out.println("Time Taken "+stopStackInser.getElapsedTime());
	      stopStackInser.reset();
	      
	
	      
	     break;
	
	
	case 3:
		
		System.out.print("Enter id to update");
		  kb.nextLine();
		   id =kb.nextInt();
		   System.out.print("Enter firstname");
			  kb.nextLine();
		      fname =kb.nextLine();
			  System.out.print("Enter usertname");
			  uname =kb.nextLine();
		
		  stopStackInser.start();
		 
		 
		  sql ="UPDATE user_details set values firstname='"+fname+"'username='"+uname+"' WHERE user_id= '"+id+"'";
		 
		  stmt.execute(sql);
	      stopStackInser.stop();
	      System.out.println("Time Taken "+stopStackInser.getElapsedTime());
	      stopStackInser.reset();
	    
	      
	      break;
	
	
	case 4:
		
	        
		String sql1 = "SELECT * FROM user_details";
		 stopStackInser.start();
        
       
	      ResultSet rs = null;
        rs = stmt.executeQuery(sql1);

        //Processing the ResultSet object

        while (rs.next())
        {
            System.out.println("ID :"+rs.getInt(1));

            System.out.println("First Name : "+rs.getString(2));

            System.out.println("Last Name :"+rs.getString(3));

    
            System.out.println("-------------------");
        }
	      System.out.println("Time Taken "+stopStackInser.getElapsedTime());
		     stopStackInser.reset();
		  
	
	break;
	
		
	
	default :System.out.println("Invalid grade");
	}	
	
	}
		

	
	}
	

