package Public_Home_Page;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;
import tableDrawFromQuery.DrawJDBCTable;
public class SearchStudents_Controller 
{

	public SearchStudents_Controller() 
 	{

 	}	
	void searchByName(String studentName) throws Exception	
	{
			System.out.println("inside Search by name std controller."+ " with name : "+studentName);		 	
		 	InstituteConnection InConn=new InstituteConnection();
			Connection conn = InConn.getConnection();
			/*
			 * for a prefix-match:

				PreparedStatement pstmt = con.prepareStatement(
				        "SELECT * FROM analysis WHERE notes like ?");
				pstmt.setString(1, notes + "%");
				or a suffix-match:
				
				pstmt.setString(1, "%" + notes);
				or a global match:
				
				pstmt.setString(1, "%" + notes + "%");
				*/
		  
		    	String query = "select Student_ID, Student_Name, Contact_No,CGPA from student where Student_Name LIKE ?";
			    
		    	
		    	PreparedStatement pstmt = conn.prepareStatement(query); // create a statement
		    	((OraclePreparedStatement)pstmt).setFixedCHAR(1,"%" + studentName + "%");
		    	
		    	ResultSet rs= pstmt.executeQuery();
			      // extract data from the ResultSet
			 while (rs.next()) 
			 {
			    	  System.out.println("successful searching");
					
			    	  	String StudentID = rs.getString("Student_ID");
						String StudentName = rs.getString("Student_Name");
						String StudentContact =rs.getString("Contact_No");
						Float StudentCGPA = rs.getFloat("CGPA");
			    			
						System.out.println(StudentID + " "+StudentName + " "+StudentContact + " "+StudentCGPA);					
						 String colToSearch=("Student_Name");
						 new DrawJDBCTable("STUDENT",studentName);									
			}	
			//;
	}	
	
	void searchByID(String stdID) throws Exception
	{
		
		System.out.println("inside Search by id std controller."+ " with id : "+stdID);
	 	
	 	InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
	    String query = "select Student_ID, Student_Name, Contact_No,CGPA from student where Student_ID = ?";
	    PreparedStatement  pstmt = conn.prepareStatement(query); // create a statement
		
	    ((OraclePreparedStatement)pstmt).setFixedCHAR(1, stdID);
	    	
	   
	    ResultSet rs  = pstmt.executeQuery();
		      // extract data from the ResultSet
		 while (rs.next()) 
		 {
			 		System.out.println("successful searching");
				
		    	  	String StudentID = rs.getString("Student_ID");
					String StudentName = rs.getString("Student_Name");
					String StudentContact =rs.getString("Contact_No");
					String StudentCGPA = rs.getString("CGPA");
		    			
					System.out.println(StudentID + " "+StudentName + " "+StudentContact + " "+StudentCGPA);					
					String colToSearch=("Student_ID");
					new DrawJDBCTable("STUDENT",stdID);									
		}	
		 
			
	}
	
}
