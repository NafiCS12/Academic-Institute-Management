package Admin_Reasearches;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConnectionDetails.InstituteConnection;

public class Admin_addResearch_controller 
{
	public Admin_addResearch_controller (Reasearches ResearchFromView) throws Exception
	{
		PreparedStatement ps;
		InstituteConnection InConn=new InstituteConnection();
		Connection conn = InConn.getConnection();
		
		String queryToInsert= "insert into Research values(?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(queryToInsert);
		ps.setString(1, ResearchFromView.Research_ID);
		ps.setString(2, ResearchFromView.getResearchCategory());
		ps.setString(3, ResearchFromView.Research_Title);
		ps.setString(4, ResearchFromView.tID); //start date of new Research
		ps.setString(5, ResearchFromView.sID); //end date of new Research
		ps.setString(6, ResearchFromView.Research_Year);
		// execute insert SQL stetement
		ps.executeUpdate();
		
	}
}
