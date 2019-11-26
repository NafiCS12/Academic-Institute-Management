package Admin_Events;

import java.sql.Date;

public class Events 
{
	String Event_ID;
	private String Event_Category;
	String Event_Location;
	//private Date Event_StartDate,Event_EndDate;
	String Event_Details,Event_StartDate,Event_EndDate;
  
  	public Events(String eID,String eCat,String eLoc,String sDate,String eDate,String eDet)
  	{
  		Event_ID = eID;
  		this.setEventCategory(eCat);
  		Event_Location= eLoc;
  		this.setEventDate(sDate,eDate);
  		Event_Details= eDet;
  		
  		 		
  	}
  	public Events() 
  	{
		
	}
	public void displayDetails()
  	{
  		System.out.println("id  is : " + this.Event_ID);
  		System.out.print("category is : " + this.getEventCategory() );
  		System.out.print("detailed : " + this.Event_Details );
  		
  	}
  	void setEventDate(String _sDate,String _eDate)
  	{
  		Event_StartDate = _sDate;
  		Event_EndDate=_eDate;
  	}
  	void setEventCategory(String sName)
  	{
  		this.Event_Category = sName;
  	}
  	String getEventStartDate()
  	{
  		return this.Event_StartDate;
  	}
  	String getEventEndDate()
  	{
  		return this.Event_EndDate;
  	}
  	String getEventCategory()
  	{
  		return this.Event_Category;
  	}
  	
}
