package FirstPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConnectionDetails.InstituteConnection;

public class Admin_login_Controller 
{
		String UserIdInputFromView;
		String PasswordInputFromView;

	public Admin_login_Controller(String UserIdInputFromView,String PasswordInputFromView) throws Exception
	{

		  
		
		//step1 create  the connection object
		
		InstituteConnection INSconn = new InstituteConnection();
		Connection con= INSconn.getConnection();
		  
		//step3 create the statement object  
		  
		//step4 execute query  - need to use a Prepared Statement here
		String selectSQL = "SELECT ADMINPW FROM ADMININFO WHERE ADMINID  = ?";
		PreparedStatement preparedStatement= con.prepareStatement(selectSQL);
		preparedStatement.setString(1, UserIdInputFromView);

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) 
		{

			String passWord = rs.getString(1);
			//System.out.println("\n\n\t correct pw is : "+ passWord);
			if( passWord.equals(PasswordInputFromView)) //grant login access
			{
				System.out.println(" login access granted to mr. "+ UserIdInputFromView);
				//setVisible(false);
				new Admin_homepage();
			}
			else
			{
				System.out.println(" denied access  to mr. "+ UserIdInputFromView);
			}

		}

		//System.out.println("running query from login page");
		//step5 close the connection object  
		con.close();  
	}

}
