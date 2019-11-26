package Admin_Students;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Admin_Students.Student;
import ConnectionDetails.InstituteConnection;

public class Admin_addStudent_Controller 
{
	public Admin_addStudent_Controller (Student stdFromView) throws Exception
	{
		PreparedStatement ps;
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		String queryToInsert= "insert into Student values(?,?,?,?)";
		
		ps = conn.prepareStatement(queryToInsert);
		ps.setString(1, stdFromView.getStudentID());
		ps.setString(2, stdFromView.getStudentName());
		ps.setString(3, stdFromView.student_Contact);
		ps.setString(4, "0.0"); //cgpa of new studnt
		

		// execute insert SQL stetement
		ps.executeUpdate();
		
		
		//now populate the enrolled Table
		
		queryToInsert= "insert into Enrolled values(?,?,?,?)";
		ps = conn.prepareStatement(queryToInsert);
		ps.setString(1, stdFromView.getStudentID());
		ps.setInt(2, stdFromView.student_Semester);
		ps.setInt(3, stdFromView.student_Batch);
		ps.setString(4, stdFromView.student_CreditCompleted); //crdt of new studnt
		// execute insert SQL stetement
		ps.executeUpdate();
	}
}
