package Admin_Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class deleteTeacherModel 
{

	String stdIdToDelete;
	public deleteTeacherModel (String _sID) throws Exception
	{
		stdIdToDelete = _sID;
	
		deleteFromTeacher(_sID);
	}


	private static void deleteFromTeacher(String idx) throws Exception 
	{
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		String queryToDelete= "DELETE FROM TEACHER WHERE TEACHER_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(queryToDelete);
		((OraclePreparedStatement)ps).setFixedCHAR(1, idx);
	
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
}
