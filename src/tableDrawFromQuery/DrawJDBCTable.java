package tableDrawFromQuery;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;

import ConnectionDetails.InstituteConnection;
public class DrawJDBCTable 
{
	String tableName;
	String studentName;
	InstituteConnection insConn = new InstituteConnection();
			
	public DrawJDBCTable(String _tableName) throws Exception //whole table draw
	{
		 Connection conn = insConn.getConnection();
		
		 tableName= _tableName;
		 try 
		 {

			// get a model for this db table and add to a JTable
			TableModel mod =	new JDBCTableModel (conn, tableName);
			JTable jtable = new JTable (mod);
			JScrollPane scroller =
			new JScrollPane (jtable, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			
			JFrame frame = new JFrame ("Displaying Table "+tableName);
			frame.getContentPane().add (scroller);
			frame.pack();
			frame.setVisible (true);

			//conn.close();

			} catch (Exception e) {
		e.printStackTrace();
			}
	}
	public DrawJDBCTable(String _tableName,String _studName) throws Exception
	{
		//System.out.println("test jdbc called from ss controller" );
		Connection conn = insConn.getConnection();
		
		 tableName= _tableName;
		 studentName= _studName;
		try 
		{

		// get a model for this db table and add to a JTable
		TableModel mod =	new JDBCTableModel (conn, tableName,studentName);
		JTable jtable = new JTable (mod);
		JScrollPane scroller =
		new JScrollPane (jtable, 
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		JFrame frame = new JFrame ("Displaying Table "+tableName);
		frame.getContentPane().add (scroller);
		frame.pack();
		frame.setVisible (true);

		//conn.close();

		} catch (Exception e) {
	e.printStackTrace();
		}
	}

	
}