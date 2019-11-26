package tableDrawFromQuery;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import oracle.jdbc.OraclePreparedStatement;

public class JDBCTableModel extends AbstractTableModel 
{
	Object[][] contents;
	String[] columnNames;
	Class[] columnClasses;
	public JDBCTableModel(Connection conn,String tableName) throws Exception
	{
		super();
		getWholeTableContents(conn,tableName);
	}

	public  JDBCTableModel(Connection conn,String tableName,String studentName) throws Exception
	{
		super();
		
		getTableContents(conn,tableName,studentName);
	}
	

	
	protected  void getWholeTableContents(Connection conn, String tableName) throws SQLException 
	{
		DatabaseMetaData meta = conn.getMetaData();
		
		ResultSet results = meta.getColumns(null, null, tableName, null);
		
		ArrayList colNamesList = new ArrayList<>();
		ArrayList colClassesList = new ArrayList<>();
		
		while( results.next())
		{
			colNamesList.add( results.getString("COLUMN_NAME" ));
			//System.out.println(" name :" + Allrs.getString("COLUMN_NAME" ));
			
			int dbType = results.getInt("DATA_TYPE");
			 
			switch(dbType)
			{
				case Types.INTEGER : 
					colClassesList.add(Integer.class);
					break;
				case Types.FLOAT : 
					colClassesList.add(Float.class);
					break;
				case Types.DOUBLE : 
				case Types.REAL :	
					colClassesList.add(Double.class);
					break;
				case Types.DATE : 
				case Types.TIME :
				case Types.TIMESTAMP :
					colClassesList.add(java.sql.Date.class);
					break;
				default :
					colClassesList.add(String.class);
					break;
			}
		}
		
		columnNames = new String[colNamesList.size()];
		colNamesList.toArray(columnNames);
		
		columnClasses = new Class[colClassesList.size()];
		colClassesList.toArray(columnClasses);
		
		//here - get data from table and put into contents array
		String queryToExecute = "select * from  "+tableName+" ";
		
		PreparedStatement  pstmt = conn.prepareStatement(queryToExecute); // create a statement
	     // ((OraclePreparedStatement)pstmt).setFixedCHAR(1, tableName);
	        
	       results = pstmt.executeQuery();
		
		
		
		ArrayList rowList = new ArrayList<>();
		while(results.next() )
		{
			ArrayList cellList = new ArrayList<>();
				for(int i=0;i<columnClasses.length;i++)
				{
					Object cellValue = null;
				
					Class ThisColumns = (columnClasses[i]);	
					
					if(ThisColumns == String.class)
					{
						cellValue = results.getString(columnNames[i]);
					}
					else if(ThisColumns == Integer.class)
					{
						cellValue = new Integer(results.getInt(columnNames[i]) );
					}
					else if(ThisColumns == Double.class)
					{
						cellValue = new Double(results.getDouble(columnNames[i]) );
					}
					else if(ThisColumns == java.sql.Date.class)
					{
						cellValue = (results.getDate(columnNames[i]) );
					}
					else
					{
						//do nothing
					}
					cellList.add(cellValue);
				}//end of for
				
				Object[] cells = cellList.toArray();
				rowList.add(cells);
				
			}//end of while
		
			//creating contents of 2 dim Array
			contents = new Object[rowList.size()][]; 
			for(int i=0;i<contents.length;i++)
			{
				contents[i] = (Object []) rowList.get(i);
			}
			
			results.close();
			pstmt.close();
		//	stmts.close();
	}
	protected void getTableContents(Connection conn,String tableName,String studentName) throws Exception
	{
		DatabaseMetaData meta = conn.getMetaData();
		
		ResultSet results = meta.getColumns(null, null, tableName, null);
		
		ArrayList colNamesList = new ArrayList<>();
		ArrayList colClassesList = new ArrayList<>();
		
		while( results.next())
		{
			colNamesList.add( results.getString("COLUMN_NAME" ));
			//System.out.println(" name :" + Allrs.getString("COLUMN_NAME" ));
			
			int dbType = results.getInt("DATA_TYPE");
			 
			switch(dbType)
			{
				case Types.INTEGER : 
					colClassesList.add(Integer.class);
					break;
				case Types.FLOAT : 
					colClassesList.add(Float.class);
					break;
				case Types.DOUBLE : 
				case Types.REAL :	
					colClassesList.add(Double.class);
					break;
				case Types.DATE : 
				case Types.TIME :
				case Types.TIMESTAMP :
					colClassesList.add(java.sql.Date.class);
					break;
				default :
					colClassesList.add(String.class);
					break;
			}
		}
		
		columnNames = new String[colNamesList.size()];
		colNamesList.toArray(columnNames);
		
		columnClasses = new Class[colClassesList.size()];
		colClassesList.toArray(columnClasses);
		
		//here - get data from table and put into contents array
		String queryToExecute = "select * from "+tableName+" ";
		 queryToExecute+=" where STUDENT_NAME = ?";
		
		PreparedStatement  pstmt = conn.prepareStatement(queryToExecute); // create a statement
	      //((OraclePreparedStatement)pstmt).setFixedCHAR(1, tableName);
	      ((OraclePreparedStatement)pstmt).setFixedCHAR(1, studentName);
		     
	       results = pstmt.executeQuery();
		
		
		
		ArrayList rowList = new ArrayList<>();
		while(results.next() )
		{
			ArrayList cellList = new ArrayList<>();
				for(int i=0;i<columnClasses.length;i++)
				{
					Object cellValue = null;
				
					Class ThisColumns = (columnClasses[i]);	
					
					if(ThisColumns == String.class)
					{
						cellValue = results.getString(columnNames[i]);
					}
					else if(ThisColumns == Integer.class)
					{
						cellValue = new Integer(results.getInt(columnNames[i]) );
					}
					else if(ThisColumns == Double.class)
					{
						cellValue = new Double(results.getDouble(columnNames[i]) );
					}
					else if(ThisColumns == java.sql.Date.class)
					{
						cellValue = (results.getDate(columnNames[i]) );
					}
					else
					{
						//do nothing
					}
					cellList.add(cellValue);
				}//end of for
				
				Object[] cells = cellList.toArray();
				rowList.add(cells);
				
			}//end of while
		
			//creating contents of 2 dim Array
			contents = new Object[rowList.size()][]; 
			for(int i=0;i<contents.length;i++)
			{
				contents[i] = (Object []) rowList.get(i);
			}
			
			results.close();
			pstmt.close();
		//	stmts.close();
		
	}
	
	//abstract tablemodel Methods
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return contents.length;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if(contents.length==0) return 0;
		else return contents[0].length;
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return contents[row][col];
	}
	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return columnNames[col];
	}

	@Override
	public Class getColumnClass(int col) {
		// TODO Auto-generated method stub
		return columnClasses[col];
	}

	

	
}
