package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
//liam dorrian
//Applied Computing

public class Assignment2_New {

	public static void main(String[] args) 
	{
		final String db_address = "jdbc:mysql://localhost:3306/user_details";
		final String db_Name = "com.mysql.jdbc.Driver";
		final Connection conn = null;
	   Statement stmt = null;

		try{
            Class.forName(db_Name); 
			Connection con = DriverManager.getConnection
					(db_address,"root","");
			int id = 0;
			String fname;
			String uname;
			final int mb =1024*1024;
			 int rowsUpdated;
             int option = 0;
             Stopwatch stopStackInser = new Stopwatch();
 			Scanner kb = new Scanner(System.in);
            
            do{
            
			//Menu System
			System.out.println("#### Options#######");
			System.out.println("1)Add records");
			System.out.println("2)delete records");
			System.out.println("3)update records");
			System.out.println("4)view records");
			System.out.println("5)Exit");
			System.out.println("#################");
			

		
			System.out.println("Please input an integer value [1-5]");
			
	
			while(!kb.hasNextInt()) 
			{
				kb.next();
				System.out.println(" Error ");
				System.out.print("Please input an integer value [1-5]");

			}
			option = kb.nextInt();
			

			

			
			//switch statement
				switch(option)
				{
                    case 1:
                    System.out.println("");
					System.out.println( "before GB called");

					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					System.out.println( "");

					System.out.print("Enter firstname");
					kb.nextLine();
					fname =kb.nextLine();

					//making sure no int can be passed in 
					while(!fname.matches("[a-zA-Z]+$"))
					{
						System.out.println(" Error ");
						System.out.print("  please enter firstname again");
						fname =kb.nextLine();
					}

					System.out.print("Enter username");
					uname =kb.nextLine();
					//making sure no int can be passed in 
					while(!uname.matches("[a-zA-Z]+$"))
					{
						System.out.println(" Error ");
						System.out.print("please enter username again");
						uname =kb.nextLine();
					}
					
					
					PreparedStatement addeemp = con.prepareStatement
							("insert into  user_details values(?,?,?)");
					addeemp.setInt(1,0);
					addeemp.setString(2, fname);
					addeemp.setString(3, uname);
					stopStackInser.start();
					rowsUpdated = addeemp.executeUpdate();
					//ensuring record in inserted.
					if (rowsUpdated > 0) {
						System.out.println("#######new record Inserted!#######");
						
						
					}
					else 
					{
						System.out.println("########RECORD NOT INSERTED#######");
						



					}


					System.gc();//calling garbage collector

					System.out.println( "");
					System.out.println( "GB called");

					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);

					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);

					stopStackInser.stop();
					System.out.println( "");
					System.out.println("Time Taken "+stopStackInser.getElapsedTime());

					stopStackInser.reset();

					break;




				case 2:

					System.out.println( "before GB called");
					System.out.println( "");
					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					System.out.println( "");

					System.out.print("Enter id to delete");


					//making sure no string can be passed in 
					while(!kb.hasNextInt()) 
					{
						kb.next();
						System.out.println(" Error ");
						System.out.print("Enter a valid id to  delete");

					}
					id = kb.nextInt();

					System.out.print("");


					stopStackInser.start();
					PreparedStatement deleteeemp = con.prepareStatement
							("DELETE from  USER_DETAILS WHERE USER_ID =?");
					deleteeemp.setInt(1,id);
					rowsUpdated = deleteeemp.executeUpdate();

					// checking if record went trough
					if (rowsUpdated > 0) 
					{

						System.out.println("new record Deleted!");
					}
					else 
					{

						System.out.println("########RECORD NOT  FOUND#######");


					}
					System.gc();//garbage collecter called



					System.out.println( "");
					System.out.println( "GB called");
					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					stopStackInser.stop();
					System.out.println( "");
					System.out.println("Time Taken "+stopStackInser.getElapsedTime());

					stopStackInser.reset();

					break;



				case 3:

					System.out.println( "before GB called");
					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					System.out.println("");

					System.out.print("Enter id to update");



					while(!kb.hasNextInt()) 
					{
						kb.next();
						System.out.println(" Error ");
						System.out.print("Id not found please try again");

					}
					id = kb.nextInt();
					kb.nextLine();
                    
					System.out.println("Enter firstname");
                    fname =kb.nextLine();
                    System.out.print("");

					while(!fname.matches("[a-zA-Z]+$"))
	                {
						System.out.println(" Error ");
						System.out.print(" please enter firstname again");
						fname =kb.nextLine();
					}

					System.out.print("Enter username");
					uname =kb.nextLine();

					while(!uname.matches("[a-zA-Z]+$"))
					{
						System.out.print(" ERROR ,please enter username again");
						uname =kb.nextLine();
					}

                    stopStackInser.start();
					PreparedStatement updateemp = con.prepareStatement
							("UPDATE user_details SET username = ? , first_name = ? where user_id = ?");
					updateemp.setString(1, uname);
					updateemp.setString(2,fname);
					updateemp.setInt(3,id);

					rowsUpdated = updateemp.executeUpdate();
					if (rowsUpdated > 0) 
					{
						System.out.println("new record Updated!");
						
					}
					else 
					{
						System.out.println("########RECORD NOT UPDATED#######");

					}

					System.gc();//garbage collector called.


					System.out.println( "");
					System.out.println( "GB called");
					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					stopStackInser.stop();
					System.out.println("");
					System.out.println("Time Taken "+stopStackInser.getElapsedTime());

					stopStackInser.reset();


					break;


				case 4:
					
					System.out.println( "before GB called");
					System.out.println( "");
					System.out.println("used memory megabytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
					System.out.println("used memory bytes"
							+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					System.out.println( "");

					stmt = con.createStatement();
					String query = "select * from user_details";
					System.gc();//garbage collector called.
					stopStackInser.start();
					ResultSet rs =  stmt.executeQuery(query);
					 User_class user = new User_class();     
				      while (rs.next()) 
				      {
				         
				    	  user.id  = rs.getInt("user_id");
				    	  user.uname   = rs.getString("username");
				    	  user.fname  = rs.getString("first_name");
					       
					         
					         System.out.println( user.id  + "  " + user.uname+"   "+ user.fname);
					         stopStackInser.stop();
						     
				        
				 }
				     


						System.out.println( "");
						System.out.println( "GB called");
						System.out.println("used memory megabytes"
								+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
						System.out.println("used memory bytes"
								+ ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /8);
					
					System.out.println("Time Taken "+stopStackInser.getElapsedTime());
					stopStackInser.reset();
					rs.close();

					break;

				case 5:

					break;

				
				
				default :System.out.println("Invalid number !! Try again");
				break;
				}
            	
            }while(option!=5);
            
					
            
		
			

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se)
			{
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");

	}
}
