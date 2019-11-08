package scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	//Create an array where shifts can be loaded
	private static Shift[] shifts = new Shift[100];
	private static int shiftCounter = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		generateFolder();
		generateFiles();
		createShift("Morning Coldside", 6);
		
	}
	
	//generates the data folder on first launch
	public static void generateFolder() {
		
		File startDir = new File("Data");
		if(!startDir.exists()) {
			if(startDir.mkdirs()) {
				System.out.println("Starting directory created");
			}
			else {
				System.out.println("Failed to create starting directory");
			}
		}
	}
	
	//generates the files on first launch
	public static void generateFiles() throws IOException{
		String fileSeperator = System.getProperty("file.separator");
		
		File shiftInfo = new File("Data" + fileSeperator + "shiftInfo.txt");
		File employeeInfo = new File("Data" + fileSeperator + "employeeInfo.txt");
		File dayInfo = new File("Data" + fileSeperator + "dayInfo.txt");
		File calendarInfo = new File("Data" + fileSeperator + "calendarInfo.txt");
		
		//creates the shift info 
		if(!shiftInfo.exists()) {
			if(shiftInfo.createNewFile()) {
				System.out.println("shiftInfo.txt created");
			}
			else {
				System.out.println("Failed to create shiftInfo.txt");
			}
		}
		
		//creates the employee info 
		if(!employeeInfo.exists()) {
			if(employeeInfo.createNewFile()) {
				System.out.println("employeeInfo.txt created");
			}
			else {
				System.out.println("Failed to create employeeInfo.txt");
			}
		}
		
		//creates the shift info 
		if(!dayInfo.exists()) {
			if(dayInfo.createNewFile()) {
				System.out.println("dayInfo.txt created");
			}
			else {
				System.out.println("Failed to create dayInfo.txt");
			}
		}
		
		//creates the shift info 
		if(!calendarInfo.exists()) {
			if(calendarInfo.createNewFile()) {
				System.out.println("calendarInfo.txt created");
			}
			else {
				System.out.println("Failed to create calendarInfo.txt");
			}
		}
	}

	/*
	 * Generates shift information and saves it to the shiftInfo.txt file
	 * public Shift(String name, int hours) 
	 */
	public static void createShift(String name, int hours) throws IOException {
		
		//file info
		String fileSeperator = System.getProperty("file.separator");
		
		//create string to be written to the file
		String shiftInfo = name + ", " + hours + "\n";
		
		//create bool to see if that value is already in the shifts array
		boolean inArray = false;
		
		//create reader and writer
		FileWriter fileWriter = new FileWriter("Data" + fileSeperator + "shiftInfo.txt");
		
		//check to see if name is already in the array
		for(int i = 0; i < shifts.length; i++) {
			
			//if the current shift is not null check it, otherwise return
			if(shifts[i] != null) {
				
				if(shifts[i].getName() == name) {
					System.out.println(name + "is already a saved shift");
					inArray = true;
					break;
				}
				
			}
			else {
				
				break;
				
			}
			
		}
		
		//if the shift is not in the array, add it and save the info
		if(inArray == false) {
			
			//write shift to file
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(shiftInfo);
			printWriter.close();
			System.out.println("Shift saved to shiftInfo.txt");
			
			
			//create shift
			Shift createdShift = new Shift(name, hours);
			shifts[shiftCounter++] = createdShift;
			
		}
		
	}
	/*
	 * Generates an employee and saves the info to the employeeInfo.txt file
	 * public Employee(String name, Shift primaryShift, int maxHours, String[]workDays, boolean worksWeekends)
	 */
	public static void createEmployee(String name, Shift primaryShift, int maxHours, String[]workDays, 
									  boolean worksWeekends) {
		
		
		
	}
}
