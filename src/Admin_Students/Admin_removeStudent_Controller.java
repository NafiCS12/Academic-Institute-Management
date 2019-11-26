package Admin_Students;


import java.sql.Connection;
import java.sql.PreparedStatement;

import Admin_Students.Student;
import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class Admin_removeStudent_Controller 
{
	public Admin_removeStudent_Controller (Student stdFromView) throws Exception
	{
		
		deleteStudentModel delStdMod = new deleteStudentModel ( stdFromView.getStudentID());
	}
}
