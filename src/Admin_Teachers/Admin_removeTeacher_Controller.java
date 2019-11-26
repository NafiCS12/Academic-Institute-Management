package Admin_Teachers;


public class Admin_removeTeacher_Controller 
{
	public Admin_removeTeacher_Controller (Teacher tFromView) throws Exception
	{
		
		deleteTeacherModel delStdMod = new deleteTeacherModel ( tFromView.getTeacherID());
	}
}
