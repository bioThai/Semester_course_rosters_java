//bioThai
//Subclass definitions

public class Section extends Course {
	//fields
	private String sectionNum;
	private String instructorID;
	private String instructorName;
	private String day;				//day that the course section is held
	private String time;			//time that the course section is held
	private String campus_room;		//campus and room locations where the course section is held
	
	/********************************************************* 
	 * Section(String, String)
	 * Subclass constructor. 
	 * Calls the superclass constructor to initialize course number and name.
	 *********************************************************/
	public Section(String num, String name)
	{
		super(num, name);
	}
	
	/********************************************************* 
	 * setSectionNum(String)
	 * Mutator method for sectionNum.
	 *********************************************************/
	public void setSectionNum(String num) 
	{
		sectionNum = num;
	}
	
	/********************************************************* 
	 * getSectionNum()
	 * Accessor method for sectionNum.
	 *********************************************************/
	public String getSectionNum()
	{
		return sectionNum;
	}
	
	
	/********************************************************* 
	 * setInstructorID(String)
	 * Mutator method for instructorID.
	 *********************************************************/
	public void setInstructorID(String instrID)
	{
		instructorID = instrID;
	}
	
	/********************************************************* 
	 * getInstructorID()
	 * Accessor method for instructorID.
	 *********************************************************/
	public String getInstructorID()
	{
		return instructorID;
	}
	
	/********************************************************* 
	 * setInstructorName(String)
	 * Mutator method for instructorName.
	 *********************************************************/
	public void setInstructorName(String instrName)
	{
		instructorName = instrName;
	}
	/********************************************************* 
	 * getInstructorName()
	 * Accessor method for instructorName.
	 *********************************************************/
	public String getInstructorName()
	{
		return instructorName;
	}
	
	/********************************************************* 
	 * setDay(String)
	 * Mutator method for day that a course section is held.
	 *********************************************************/
	public void setDay(String dayInput)
	{
		day = dayInput;
	}
	
	/********************************************************* 
	 * getDay()
	 * Accessor method for day that a course section is held.
	 *********************************************************/
	public String getDay()
	{
		return day;
	}
	
	/********************************************************* 
	 * setTime(String)
	 * Mutator method for time that a course section is held.
	 *********************************************************/
	public void setTime(String timeInput)
	{
		time = timeInput;
	}
	
	/********************************************************* 
	 * getTime()
	 * Accessor method for time that a course section is held.
	 *********************************************************/
	public String getTime()
	{
		return time;
	}
	
	/********************************************************* 
	 * setCampusRoom(String)
	 * Mutator method for campus and room locations where a course section is held.
	 *********************************************************/
	public void setCampusRoom(String campus_room_input)
	{
		campus_room = campus_room_input;
	}
	
	/********************************************************* 
	 * getCampusRoom()
	 * Accessor method for campus and room locations where a course section is held.
	 *********************************************************/
	public String getCampusRoom()
	{
		return campus_room;
	}
	
}
