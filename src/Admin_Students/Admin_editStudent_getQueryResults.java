package Admin_Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.OraclePreparedStatement;
import ConnectionDetails.InstituteConnection;

public class Admin_editStudent_getQueryResults 
{
	

	public static Student getQueryResult(String inputStdID) throws Exception 
	{
		
		System.out.println("\t called with id : "+ inputStdID);
		InstituteConnection insCon = new InstituteConnection();
		Connection conn = insCon.getConnection();
		//String selectNameGivedID = "SELECT STUDENT_NAME,CONTACT_NO,CGPA FROM STUDENT WHERE STUDENT_ID  = ?";
		String selectNameGivedID = "SELECT STUDENT_ID,STUDENT_NAME,CONTACT_NO,CGPA FROM STUDENT WHERE STUDENT_ID  = ?";
		
		PreparedStatement preparedStatement= conn.prepareStatement(selectNameGivedID);
		((OraclePreparedStatement)preparedStatement).setFixedCHAR(1, inputStdID);

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();
		String inputStdName = null;
		String inputStdCntct = null;
		String inputStdCG = null ;
		String id=null;
		while(rs.next())
		{
		//	System.out.println("inside name with std id # "+ inputStdID+" is : "+inputStdName);
			
			System.out.println("inside std table query");
			id = rs.getString(1);
			inputStdName = rs.getString(2);
			System.out.println("name " + inputStdName);
			inputStdCntct = rs.getString(3);
			System.out.println("contact " + inputStdCntct);
			inputStdCG = rs.getString(4);
			System.out.println("result  : " + inputStdCG);
		}
		
		System.out.println("\n\nname : "+ inputStdName+" CG : "+inputStdCG+" with id : "+ inputStdID);
		
	//	String selectEnrolledInfoGivedID = "SELECT SEMESTER,BATCH_YEAR,CREDIT_COMPLETED FROM ENROLLED WHERE STUDENT_ID  = ?";
		String selectEnrolledInfoGivedID = "SELECT STUDENT_ID,SEMESTER,BATCH_YEAR,CREDIT_COMPLETED FROM ENROLLED WHERE STUDENT_ID  = ?";

		PreparedStatement ps;

		ps = conn.prepareStatement(selectEnrolledInfoGivedID) ;
		((OraclePreparedStatement)ps).setFixedCHAR(1, inputStdID);
		ResultSet rs2 =ps.executeQuery();
		int inputStdBatch = 0;
		int inputStdSem = 0;
		String inputStdCredit = "0.0";
		while(rs2.next())
		{
			System.out.println("inside enrolled table query");
			id = rs2.getString(1);
			inputStdSem = rs2.getInt(2);
			inputStdBatch = rs2.getInt(3);
			inputStdCredit = rs2.getString(4);
		}
		
		System.out.println("batch with std id - "+ inputStdID+" is : "+inputStdBatch );
		Student ret=new Student(inputStdID, inputStdName,  inputStdCntct, inputStdCG, inputStdSem,inputStdBatch, inputStdCredit);
		System.out.print("caliing ret from getQueryRes");
		//ret.displayDetails();
		return ret;
	}

	
	
	
}
