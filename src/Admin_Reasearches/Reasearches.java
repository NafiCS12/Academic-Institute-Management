package Admin_Reasearches;



public class Reasearches 
{
	String Research_ID;
	private String Research_Category;
	String Research_Title,tID,sID,Research_Year;
  
  	public Reasearches(String eID,String eCat,String eTitle,String t,String s,String y)
  	{
  		Research_ID = eID;
  		this.setResearchCategory(eCat);
  		Research_Title=eTitle;
	  	tID = t;
	  	sID = s;
	  	Research_Year= y;
  		
  		 		
  	}
  	public Reasearches() 
  	{
		
	}
	public void displayDetails()
  	{
  		System.out.println("id  is : " + this.Research_ID);
  		System.out.print("category is : " + this.getResearchCategory() );
  		
  	}
  	
  	void setResearchCategory(String sName)
  	{
  		this.Research_Category = sName;
  	}

  	String getResearchCategory()
  	{
  		return this.Research_Category;
  	}
  	
}
