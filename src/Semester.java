//bioThai
//Main class: Reads and processes course info and student registration data from two text file, and associates student enrollment with certain course sections.

import javax.swing.JOptionPane;		//needed to show dialog boxes
import java.io.*;					//java.io package provides classes (eg, File, PrintWriter, FileWriter) for input/output operations
import java.util.Scanner;			//needed to read input from file
import java.util.ArrayList;

public class Semester {
	//fields
	private Scanner courseInfoFile, studentRegistFile;
	private ArrayList<Section> sectionList = new ArrayList<Section>();
	private ArrayList<ArrayList<String>> courseRoster = new ArrayList<ArrayList<String>>();	//a 2D arrayList. 
																							//Each nested arrayList holds the student roster for a specific section of a course. 
																							//0th index of each nested arrayList holds a specific section number for a course, 
																							//subsequent elements in each nested arrayList hold all the student numbers of enrolled students in that section 
	/********************************************************* 
	 * openInputFiles()
	 * Opens the course info and student registration input files.
	 *********************************************************/
	private void openInputFiles() throws IOException
	{
		//create File objects that represent the files in the given paths
		File inputFile1 = new File("CourseInfo.txt");
		File inputFile2 = new File("StudentRegistration.txt");
	
		//create Scanner objs that can read items from given File objs 
		courseInfoFile = new Scanner(inputFile1);
		studentRegistFile = new Scanner(inputFile2);	
	}
	
	/********************************************************* 
	 * processSectionInput()
	 * Reads through the course info input file, which contains general course info and info for each section of a course.
	 * Creates a Section object for each section listed in the input file and sets the object's fields.
	 * Adds each Section object to an arrayList containing all the general section info for a given course.
	 * Adds each Section object's sectionNum field value to arrayLists that will hold student roster/registration information.
	 *********************************************************/
	private void processSectionInput() throws IOException
	{
		//local variables
		String courseNum, courseName, lineRead;
		int courseRosterIndex = 0;
		
		courseNum = courseInfoFile.nextLine();
		courseName = courseInfoFile.nextLine();
		while (courseInfoFile.hasNext())
		{
			lineRead = courseInfoFile.nextLine();
			if (lineRead.isEmpty())
			{
				continue;
			}
			else
			{
				//create a new section for a given course
				Section sectionObj = new Section(courseNum, courseName);
				
				//set the fields for the sectionObj
				sectionObj.setSectionNum(lineRead);
				sectionObj.setInstructorName(courseInfoFile.nextLine());
				sectionObj.setInstructorID(courseInfoFile.nextLine());
				sectionObj.setDay(courseInfoFile.nextLine());
				sectionObj.setTime(courseInfoFile.nextLine());
				sectionObj.setCampusRoom(courseInfoFile.nextLine());
				
				sectionList.add(sectionObj);
				
				//add a new element of type ArrayList<String> to the courseRoster arrayList
				courseRoster.add(new ArrayList<String>());
				//add section number (lineRead) to the newly-created nested arrayList in courseRoster
				courseRoster.get(courseRosterIndex).add(lineRead);
				//increment courseRosterIndex for each new ArrayList<String> element added
				courseRosterIndex++;
			}
		}
	}
	
	/********************************************************* 
	 * processStudentInput()
	 * Reads through the student registration input file.
	 * Adds each student ID to an arrayList corresponding to the section in which the student is enrolled.
	 *********************************************************/
	private void processStudentInput() throws IOException
	{
		//local variables
		String studentID, studentSection;
		
		while (studentRegistFile.hasNext())
		{
			studentID = studentRegistFile.nextLine();
			studentSection = studentRegistFile.nextLine();
			
			//for each nested arrayList (a sectionRoster) in the courseRoster arrayList
			for (ArrayList<String> sectionRoster : courseRoster)
			{
				//if the section number stored in 0th index of each nested arrayList is equal to the studentSection 
				if (sectionRoster.get(0).equals(studentSection))
				{
					sectionRoster.add(studentID);
				}
			}
		}
	}
	
	/********************************************************* 
	 * closeInputFiles()
	 * Closes the files that are currently open.
	 *********************************************************/
	private void closeInputFiles() throws IOException
	{
		courseInfoFile.close();
		studentRegistFile.close();		
	}
	
	/********************************************************* 
	 * sortCourseRoster()
	 * Sort the student IDs for each nested arrayList (a sectionRoster) in courseRoster arrayList.
	 * Student IDs are sorted in ascending order using selection sort algorithm.
	 * Index 0 of each nested arrayList holds a section number, so index 0 will be excluded from the sorting algorithm.
	 *********************************************************/
	private void sortCourseRoster()
	{
		//local variables
		int startScan, index, minIndex;
		String minValue;
		
		//for each nested arrayList (a sectionRoster) in the courseRoster arrayList
		for (ArrayList<String> sectionRoster : courseRoster)
		{
			//sort the student IDs (startScan starts at arrayList index 1, where the first ID is stored)
			for (startScan = 1; startScan < (sectionRoster.size() - 1); startScan++)
			{
				minIndex = startScan;
				minValue = sectionRoster.get(startScan);
				for (index = startScan + 1; index < sectionRoster.size(); index++)
				{
					if (sectionRoster.get(index).compareTo(minValue) < 0)
					{
						minValue = sectionRoster.get(index);
						minIndex = index;
					}
				}
				//set the value stored in minIndex element to the value stored in startScan element of sectionRoster
				sectionRoster.set(minIndex, sectionRoster.get(startScan));
				//set the value stored in startScan element to minValue
				sectionRoster.set(startScan, minValue);
			}
		}
	}
	
	/********************************************************* 
	 * displayOutput()
	 * Displays the course info, section info, and student roster for each section of a course.
	 *********************************************************/
	private void displayOutput()
	{
		//local variables
		String sectionRosterString;	//a string to hold the IDs of all students in the roster for a given section
		
		for (Section sectionObj : sectionList)
		{
			//set string back to empty
			sectionRosterString = "";
			
			//for each nested arrayList (a sectionRoster) in the courseRoster arrayList
			for (ArrayList<String> sectionRoster : courseRoster)
			{
				//if the section number stored in 0th index of each sectionRoster is equal to the section number of the current sectionObj 
				if (sectionRoster.get(0).equals(sectionObj.getSectionNum()))
				{
					//add all the student IDs in that sectionRoster to the sectionRosterString
					for (int i = 1; i < sectionRoster.size(); i++)
					{
						sectionRosterString += sectionRoster.get(i) + "\n";
					}
				}
			}
			JOptionPane.showMessageDialog(null,
					sectionObj.getCourseNum() + " - " + sectionObj.getCourseName()
					+ "\nSection: " + sectionObj.getSectionNum()
					+ "\n\nInstructor: " + sectionObj.getInstructorName()
					+ "\nDay/Time: " + sectionObj.getDay() + " " + sectionObj.getTime()
					+ "\nCampus/Room: " + sectionObj.getCampusRoom()
					+ "\n\nStudent Roster"
					+ "\n" + sectionRosterString
					);
		}
	}
	
	/********************************************************* 
	 * driver()
	 * Handles the order of execution for the program.
	 * Catches thrown exceptions.
	 *********************************************************/
	private void driver()
	{
		try
		{
			openInputFiles();
			processSectionInput();
			processStudentInput();
			closeInputFiles();
			sortCourseRoster();
			displayOutput();
		}
		catch(IOException exceptionObj)
		{
			//display default system error message
			System.out.println(exceptionObj.getMessage());
		}
	}
	
	/********************************************************* 
	 * main()
	 * Instantiates an object of type Semester.
	 * Calls the driver method.
	 *********************************************************/
	public static void main(String[] args) {
		Semester fall2020 = new Semester();
		fall2020.driver();
		
		//required to stop any JOptionPane threads from continuing to run in the JVM after end of main() is reached
		System.exit(0);
	}

}
