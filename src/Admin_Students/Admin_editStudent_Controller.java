package Admin_Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class Admin_editStudent_Controller 
{
	public Admin_editStudent_Controller (Student stdFromView,int NewSemester) throws Exception
	{
		PreparedStatement ps;
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		System.out.println("inside A E Controller. \t "+ stdFromView.student_CGPA+ " is the new cg");
		conn.setAutoCommit(false); //transaction block start
		String queryToUpdate= "UPDATE STUDENT SET CGPA = ? WHERE STUDENT_ID = ?";
			ps = conn.prepareStatement(queryToUpdate);
			ps.setString(1,stdFromView.student_CGPA);
		   // ps.setString(2,stdFromView.getStudentID());
			((OraclePreparedStatement)ps).setFixedCHAR(2, stdFromView.getStudentID());
		 
		    // call executeUpdate to execute our sql update statement
		ps.executeUpdate();
		conn.commit();
		System.out.print(" after updating the table student \n ");
		//stdFromView.displayDetails();
		//now show result
		
		conn.setAutoCommit(false); //transaction block start
		queryToUpdate= "UPDATE ENROLLED SET SEMESTER = ?, CREDIT_COMPLETED = ? WHERE STUDENT_ID = ?";
		ps = conn.prepareStatement(queryToUpdate);
		ps.setInt(1,NewSemester);
		ps.setString(2,stdFromView.student_CreditCompleted);
	    //ps.setString(3,stdFromView.getStudentID());
		((OraclePreparedStatement)ps).setFixedCHAR(3, stdFromView.getStudentID());
		 
	 
	    // call executeUpdate to execute our sql update statement
		ps.executeUpdate();
		
		//trigger #1
		
		conn.commit();
		System.out.print(" after updating the table enrolled \n ");
		stdFromView.displayDetails();
		
		ps.close();
		conn.close();
		
		
	}
}
