package Admin_Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class Admin_editTeacher_Controller 
{
	public Admin_editTeacher_Controller (Teacher stdFromView,String NewDesignation) throws Exception
	{
		PreparedStatement ps;
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		conn.setAutoCommit(false); //transaction block start
		String queryToUpdate= "UPDATE Teacher SET DESIGNATION = ? WHERE Teacher_ID = ?";
			ps = conn.prepareStatement(queryToUpdate);
			((OraclePreparedStatement)ps).setFixedCHAR(1, stdFromView.teacher_Designation );
			((OraclePreparedStatement)ps).setFixedCHAR(2, stdFromView.getTeacherID());
		 
		// call executeUpdate to execute our sql update statement
		ps.executeUpdate();
		conn.commit();
		
		
		ps.close();
		conn.close();
		
	}
}
