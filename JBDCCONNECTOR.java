package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class JBDCCONNECTOR 
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
	 
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	     // System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();
	      
	     // System.out.print("Enter record to delete");
		 // int id =kb.nextInt();
		  
		 
		 // String sql = "DELETE FROM user_details WHERE user_id = "+id;
	     // stmt.executeUpdate(sql);
	      
	      
	      String sql = "SELECT * FROM user_details";
	      
          //Step 4 : Executing The Query

          //We are using executeQuery() method as we are executing SELECT statement
	      ResultSet rs = null;
          rs = stmt.executeQuery(sql);

          //Processing the ResultSet object

          while (rs.next())
          {
              System.out.println("ID :"+rs.getInt(1));

              System.out.println("First Name : "+rs.getString(2));

              System.out.println("Last Name :"+rs.getString(3));

      
              System.out.println("-------------------");
          }
	      
	      //stmt.executeUpdate(sql);
	      //System.out.println("records deleted into the table...");
	      stmt.executeUpdate(sql);
	      
	      
	      
	      
	      
	      int mb=1024*1024;
	      
	      
	      System.out.println( "before GB called");
			System.out.println( "");
			System.out.println("used memory megabytes"
					+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
			System.out.println("used memory bytes"
					+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
			System.out.println( "");

			
			
			System.gc();//garbage collector called.


			System.out.println( "");
			System.out.println( "GB called");
			System.out.println("used memory megabytes"
					+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
			System.out.println("used memory bytes"
					+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	
	
	
	
	   
	
	
	
}
}