package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) 
	 {
		Stopwatch stopStackInser = new Stopwatch();
		 try
		  {
		 
		  Class.forName("com.mysql.jdbc.Driver"); 
	      Connection con = DriverManager.getConnection
	      ("jdbc:mysql://localhost:3306/user_details","root","");
	      PreparedStatement updateemp = con.prepareStatement
	      ("DELETE from  USER_DETAILS WHERE USER_ID =?");
	      updateemp.setInt(1,187584);
	      updateemp.executeUpdate();
	      Statement stmt = con.createStatement();
	      String query = "select * from user_details";
	      ResultSet rs =  stmt.executeQuery(query);
	      System.out.println("Name age address");
	      while (rs.next()) 
	      {
	         
	    	     int user_id = rs.getInt("user_id");
	    	     String username = rs.getString("username");
		         String first_name = rs.getString("first_name");
		       
		         
		         System.out.println(user_id + "  " +username+"   "+ first_name);
		        
	        
	        
	 }
	      
	      
		  
	 }
		 
		  catch( SQLException se )
		  {
		      //System.out.println( "SQL Exception:" ) ;

		     //Loop through the SQL Exceptions
		      while( se != null )
		      {
		          System.out.println( "State  : " + se.getSQLState()  ) ;
		          System.out.println( "Message: " + se.getMessage()   ) ;
		          System.out.println( "Error  : " + se.getErrorCode() ) ;

		          se = se.getNextException() ;
		      }
		  }
		  catch( Exception e )
		  {
		      System.out.println( e ) ;
		  }
	   
	}
		  }


