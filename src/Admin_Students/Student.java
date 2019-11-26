package Admin_Students;

public class Student 
{
	private String student_ID;
	private String student_Name;
	String student_Contact;
	String student_CGPA;
	int student_Semester;
	int student_Batch;
	String student_CreditCompleted;
 
  
  	public Student(String sID,String sName,String sContact,String sCG,int sSem,int sBatch,String sCrdt)
  	{
  		//student_ID = sID;
  		this.setStudentID(sID);
  		this.setStudentName(sName);
  		student_Contact = sContact;
  		student_CGPA = sCG;
  		student_Semester = sSem;
  	    student_Batch = sBatch;
  		student_CreditCompleted= sCrdt;
  		 		
  	}
  	public Student() 
  	{
		
	}
	public void displayDetails()
  	{
  		System.out.println("Name is : " + this.getStudentName());
  		System.out.print("ID is : " + this.getStudentID());
  		System.out.print(" \tContact is : " + this.student_Contact);
  		System.out.print(" \tCGPA is : " + this.student_CGPA);
  		System.out.println("enrolled details : "+ this.student_Semester+" "+this.student_Batch);
  		
  		
  	}
  	void setStudentID(String sID)
  	{
  		this.student_ID = sID;
  	}
  	void setStudentName(String sName)
  	{
  		this.student_Name = sName;
  	}
  	String getStudentID()
  	{
  		return this.student_ID;
  	}
  	String getStudentName()
  	{
  		return this.student_Name;
  	}
  	
 
}
