package Admin_Teachers;

import java.sql.Date;

public class Teacher 
{
	private String teacher_ID;
	private String teacher_Name;
	String teacher_Contact;
	String teacher_joinDate;
	String teacher_Designation;
	
  
  	public Teacher(String tID,String tName,String tContact,String tJoin,String tDesig )
  	{
  		//student_ID = sID;
  		this.setTeacherID(tID);
  		this.setTeacherName(tName);
  		teacher_Contact = tContact;
  		teacher_joinDate = tJoin;
  		teacher_Designation = tDesig;
  	}
  	public Teacher() 
  	{
		
	}
	public void displayDetails()
  	{
  		System.out.println("Name is : " + this.getTeacherName());
  		System.out.print("ID is : " + this.getTeacherID());
  		System.out.print(" \tContact is : " + this.teacher_Contact);
  		System.out.print(" \tjoining date is : " + this.teacher_joinDate.toString());
  		System.out.println(" designation : "+this.teacher_Designation);
  		
  		
  	}
  	void setTeacherID(String sID)
  	{
  		this.teacher_ID = sID;
  	}
  	void setTeacherName(String sName)
  	{
  		this.teacher_Name = sName;
  	}
  	String getTeacherID()
  	{
  		return this.teacher_ID;
  	}
  	String getTeacherName()
  	{
  		return this.teacher_Name;
  	}
  	
 
}
