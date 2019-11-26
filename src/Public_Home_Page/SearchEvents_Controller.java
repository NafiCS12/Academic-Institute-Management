package Public_Home_Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;
import tableDrawFromQuery.DrawJDBCTable;

public class SearchEvents_Controller 
{

	public void searchByCategory(String inputCategory) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		String query = "select Event_ID, E_Category, E_Location,E_STARTDATE,E_ENDDATE,Event_Details from Event where E_Category LIKE ?";
	    
    	
    	PreparedStatement pstmt = conn.prepareStatement(query); // create a statement
    	((OraclePreparedStatement)pstmt).setFixedCHAR(1,"%" + inputCategory + "%");
    	
    	ResultSet rs= pstmt.executeQuery();
	      // extract data from the ResultSet
		 while (rs.next()) 
		 {
		    	  System.out.println("successful searching");
				  			
				 								
		}	
		 String whichColToSearch =rs.getString("E_Category");
		// new DrawJDBCTable("EVENT",whichColToSearch,inputCategory);
		 new DrawJDBCTable("EVENT",inputCategory);
		 pstmt.close();
		 conn.close();
	}

}
