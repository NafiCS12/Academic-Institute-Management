package Admin_Events;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Admin_Students.Student;
import ConnectionDetails.InstituteConnection;

public class Admin_addEvent_Controller 
{
	public Admin_addEvent_Controller (Events EventFromView) throws Exception
	{
		PreparedStatement ps;
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		String queryToInsert= "insert into Event values(?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(queryToInsert);
		ps.setString(1, EventFromView.Event_ID);
		ps.setString(2, EventFromView.getEventCategory());
		ps.setString(3, EventFromView.Event_Location);
		ps.setString(4, EventFromView.getEventStartDate()); //start date of new event
		ps.setString(5, EventFromView.getEventEndDate()); //end date of new event
		ps.setString(6, EventFromView.Event_Details);
		// execute insert SQL stetement
		ps.executeUpdate();
		
	}
}
