package Admin_Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class testDriver 
{
	
	public static void main(String[] args) throws Exception
	{
		//Student std = Admin_editStudent_getQueryResults.getQueryResult("S201405001");
		//Admin_removeStudent_Controller s =new Admin_removeStudent_Controller(std);
		
		//
		//
		//
		//deleteE("S201205054");
		//deleteEvent("E102");
		//deleteEvent(101);
	//	
		deleteS("S201205054");
		
		//s.searchByID("S201205036");
	}

	private static void deleteE(String idx) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		//System.out.println("\n\ncalled with A R S Cnt/ .\n dipaying contents ");
		
	//	stdFromView.displayDetails();
		
		String queryToDelete2= "DELETE FROM enrolled WHERE student_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(queryToDelete2);
		((OraclePreparedStatement)ps).setFixedCHAR(1, idx);
		
		// execute delete SQL stetement
		ps.executeUpdate();
		  /*Statement stmt = conn.createStatement();
	      String sql = "DELETE FROM enrolled " +
	                   "WHERE student_id = "+ idx;
	      stmt.executeUpdate(sql);*/

	}

	private static void deleteS(String idx) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		//System.out.println("\n\ncalled with A R S Cnt/ .\n dipaying contents ");
		
	//	stdFromView.displayDetails();
		
		String queryToDelete= "DELETE FROM student WHERE student_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(queryToDelete);
		((OraclePreparedStatement)ps).setFixedCHAR(1, idx);
		
		// execute delete SQL stetement
		ps.executeUpdate();
	}
	private static void deleteEvent(int idx) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		//System.out.println("\n\ncalled with A R S Cnt/ .\n dipaying contents ");
		
	//	stdFromView.displayDetails();
		
		String queryToDelete= "DELETE FROM TEST WHERE POPULATION = ?";
		
		PreparedStatement ps = conn.prepareStatement(queryToDelete);
		((OraclePreparedStatement)ps).setInt(1, idx);
		
		// execute delete SQL stetement
		ps.executeUpdate();
	}
}
