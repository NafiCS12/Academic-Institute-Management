package Admin_Students;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class deleteStudentModel 
{

	String stdIdToDelete;
	public deleteStudentModel (String _sID) throws Exception
	{
		stdIdToDelete = _sID;
		deleteFromEnrolled(_sID);
		deleteFromStudent(_sID);
	}


	public static void deleteFromEnrolled(String idx) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();

		String queryToDelete2= "DELETE FROM enrolled WHERE student_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(queryToDelete2);
		((OraclePreparedStatement)ps).setFixedCHAR(1, idx);	
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	private static void deleteFromStudent(String idx) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		String queryToDelete= "DELETE FROM student WHERE student_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(queryToDelete);
		((OraclePreparedStatement)ps).setFixedCHAR(1, idx);
	
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
}
