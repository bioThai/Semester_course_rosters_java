//bioThai
//Superclass definitions

public class Course {
	//fields
	protected String courseNum;
	protected String courseName;
	
	/********************************************************* 
	 * Course(String, String)
	 * Superclass constructor. Initializes courseNum and courseName.
	 *********************************************************/
	public Course(String num, String name)
	{
		courseNum = num;
		courseName = name;
	}
	
	/********************************************************* 
	 * setCourseNum(String)
	 * Mutator method for courseNum. 
	 *********************************************************/
	public void setCourseNum(String num)
	{
		courseNum = num;
	}
	
	/********************************************************* 
	 * getCourseNum()
	 * Accessor method for courseNum.
	 *********************************************************/
	public String getCourseNum()
	{
		return courseNum;
	}
	
	/********************************************************* 
	 * setCourseName(String)
	 * Mutator method for courseName.
	 *********************************************************/
	public void setCourseName(String name)
	{
		courseName = name;
	}
	
	/********************************************************* 
	 * getCourseName()
	 * Accessor method for courseName.
	 *********************************************************/
	public String getCourseName()
	{
		return courseName;
	}

}
