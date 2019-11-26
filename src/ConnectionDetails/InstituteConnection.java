package ConnectionDetails;

import java.sql.Connection;
import java.sql.DriverManager;

public class InstituteConnection 
{
	public InstituteConnection()
	{
		
		
	}
	
	public Connection getConnection()  throws Exception
	{
			
			String driver = "oracle.jdbc.driver.OracleDriver";
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		   // String username = "ins";
		    //String password = "ins";
		    String username,password;
		    username= password="bis";
		    Class.forName(driver);
		    Connection newCon = DriverManager.getConnection(url, username, password);
		    
		return newCon;
	}
}
