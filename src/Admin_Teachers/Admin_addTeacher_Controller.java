package Admin_Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class Admin_addTeacher_Controller 
{
	public Admin_addTeacher_Controller (Teacher stdFromView) throws Exception
	{
		PreparedStatement ps;
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		String queryToInsert= "insert into Teacher values(?,?,?,?,?)";
		
		ps = conn.prepareStatement(queryToInsert);
		((OraclePreparedStatement)ps).setFixedCHAR(1, stdFromView.getTeacherID());
		((OraclePreparedStatement)ps).setFixedCHAR(2, stdFromView.getTeacherName());
		((OraclePreparedStatement)ps).setFixedCHAR(3, stdFromView.teacher_Contact);
		((OraclePreparedStatement)ps).setFixedCHAR(4, stdFromView.teacher_joinDate);
		((OraclePreparedStatement)ps).setFixedCHAR(4, stdFromView.teacher_Designation);
		
		// execute insert SQL stetement
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	
	}
}
