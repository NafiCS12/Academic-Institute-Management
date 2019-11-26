package Admin_Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import ConnectionDetails.InstituteConnection;
import oracle.jdbc.OraclePreparedStatement;

public class Admin_editTeacher_getQueryResults 
{

	public static Teacher getQueryResult(String inputTchrID) throws Exception 
	{
		System.out.println("\t called with id : "+ inputTchrID);
		InstituteConnection insCon = new InstituteConnection();
		Connection conn = insCon.getConnection();
		String selectNameGivedID = "SELECT TEACHER_ID,TEACHER_NAME,CONTACT_NO,JOINING_DATE,DESIGNATION FROM TEACHER WHERE TEACHER_ID  = ?";
		
		PreparedStatement preparedStatement= conn.prepareStatement(selectNameGivedID);
		((OraclePreparedStatement)preparedStatement).setFixedCHAR(1, inputTchrID);

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();
		String id=null;
		String inputStdName = null;
		String inputStdCntct = null;
		String inputJoin = null ;
		String inputDesig = null ;
	
		while(rs.next())
		{
			id = rs.getString(1);
			inputStdName = rs.getString(2);		
			inputStdCntct = rs.getString(3);
			inputJoin = rs.getString(4);
			inputDesig = rs.getString(5);
			//System.out.println("name " + inputStdName);
			//System.out.println("contact " + inputStdCntct);		
			//System.out.println("joined on   : " + inputJoin);	
		}
		
		
	
		Teacher ret=new Teacher(inputTchrID, inputStdName,  inputStdCntct, inputJoin , inputDesig);
		System.out.print("caliing ret from getQueryRes");
		ret.displayDetails();
		preparedStatement.close();
		conn.close();
		return ret;
	}

}
