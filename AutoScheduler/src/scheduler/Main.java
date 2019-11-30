package scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	//Create an array where shifts can be loaded
	private static Shift[] shifts = new Shift[100];
	private static Day[] days = new Day[7];
	private static Employee[] employees = new Employee[100];
	private static int shiftCounter = 0;
	private static int dayCounter = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//generate folders and files on first start up
		generateFolder();
		generateFiles();
		
		//load info into arrays
		loadShifts();
		loadDays();
		
		//create employee and test employee save
		Shift[] possibleShift = {shifts[2], shifts[8]};
		Day[] workDays = {days[0], days[1], days[2], days[6]};
		int[] daysOff = {};
		
		Employee sam = new Employee("Sam", 2578, 14, 0, shifts[9], possibleShift, workDays, true, daysOff);
		Employee lynn = new Employee("Lynn", 2580, 40, 0, shifts[9], possibleShift, workDays, true, daysOff);
		employees[0] = sam;
		employees[1] = lynn;
		
		//save info into text files
		saveDays();
		saveShifts();
		saveEmployees();
		//createShift();
		for(int i = 0; i < shifts.length; i++) {
		
			if(shifts[i] == null) {
				break;
			}
			else {
				shifts[i].printShift();
			}
		}
		
		for(int i = 0; i < days.length; i++) {
			
			if(days[i] == null) {
				break;
			}
			else {
				days[i].printDay();
			}
		}
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
	 * Generates shift information, saves it to the shiftInfo.txt file, and adds it to the shifts array
	 * public Shift(String name, int hours) 
	 */
	public static void createShift(String name, int hours) throws IOException {
		
		//file info
		String fileSeperator = System.getProperty("file.separator");
		
		//create string to be written to the file
		String shiftInfo = "Name: " + name + " " + "Hours: " + hours + "\n";
		
		//create bool to see if that value is already in the shifts array
		boolean inArray = false;
		
		//create reader and writer
		FileWriter fileWriter = new FileWriter("Data" + fileSeperator + "shiftInfo.txt", true);
		
		//check to see if name is already in the array
		for(int i = 0; i < shifts.length; i++) {
			
			//if the current shift is not null check it, otherwise return
			if(shifts[i] != null) {
				if(shifts[i].getName().equals(name)) {
					System.out.println(name + " is already a saved shift");
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
			fileWriter.close();
			System.out.println("Shift saved to shiftInfo.txt");
			
			//create shift
			Shift createdShift = new Shift(name, hours);
			shifts[shiftCounter++] = createdShift;
			
		}
		
	}
	/*
	 * Saves shift info from the array into the shiftInfo.txt file
	 */
	public static void saveShifts() throws IOException{
		String fileSeperator = System.getProperty("file.separator");
		//clear the file
		FileWriter fileWriter = new FileWriter("Data" + fileSeperator + "shiftInfo.txt", true);
		PrintWriter pw = new PrintWriter(fileWriter);
		
		PrintWriter clear = new PrintWriter("Data" + fileSeperator + "shiftInfo.txt");
		clear.close();
		
		for(int i = 0; i < shifts.length; i++) {
			
			if(shifts[i] != null) {
				
				//create string to be written to the file
				String shiftInfo = "Name: " + shifts[i].getName() + " " + "Hours: " + shifts[i].getHours() + "\n";
				
				pw.print(shiftInfo);
				
			}
			else{
				break;
			}
		}
		
		pw.close();
		fileWriter.close();
		System.out.println("Shift(s) saved to shiftInfo.txt");
		
	}
	/*
	 * Loads shift info into the array from the shiftInfo.txt file
	 */
	public static void loadShifts() throws IOException{
		
		//create scanner for the shiftInfo text file
		String fileSeperator = System.getProperty("file.separator");
		File shiftInfo = new File("Data" + fileSeperator + "shiftInfo.txt");
		Scanner sc = new Scanner(shiftInfo);
		sc.useDelimiter("\\n");
		
		//read the information
		//check that the file isn't empty
		while(sc.hasNext() == true) {
			
			String curShiftInfo = sc.nextLine();
			String[] line = curShiftInfo.split(" ");
			String shiftName = "";
			int hours = 0;
			int hourLocation = 0;
			
			for(int i = 0; i < line.length; i++) {
				
				if(line[i].equals("Hours:")) {
					hourLocation = i;
					hours = Integer.parseInt(line[i + 1]);
				}
				
			}
			for(int i = 0; i < hourLocation; i++) {
				if(!line[i].equals("Name:") && i + 1 != hourLocation) {
					shiftName += line[i] + " ";
				}
				else if(!line[i].equals("Name:") && i + 1 == hourLocation) {
					shiftName += line[i];
				}
			}
			
			Shift s = new Shift(shiftName, hours);
			shifts[shiftCounter++] = s;
			System.out.println("Loaded: " + s.getName());
			
			
		}
		//close the scanner
		
		sc.close();
	}
	/*
	 * Saves day info from the array into the dayInfo.txt file
	 */
	public static void saveDays() throws IOException {
		
		String fileSeperator = System.getProperty("file.separator");
		//clear the file
		FileWriter fileWriter = new FileWriter("Data" + fileSeperator + "dayInfo.txt", true);
		PrintWriter pw = new PrintWriter(fileWriter);
		
		PrintWriter clear = new PrintWriter("Data" + fileSeperator + "dayInfo.txt");
		clear.close();
		
		for(int i = 0; i < days.length; i++) {
			
			if(days[i] != null) {
				
				System.out.println(arrayToString(days[i].getRequiredShifts()));
				String requiredShifts = arrayToString(days[i].getRequiredShifts());
				//create string to be written to the file
				String dayInfo = "Name: " + days[i].getName() + " " + "Total Shifts: " + days[i].getTotalNumberOfShifts() + " " + "Required Shifts: " + requiredShifts + "\n";
				
				pw.print(dayInfo);
				
			}
			else{
				break;
			}
		}
		pw.close();
		fileWriter.close();
		System.out.println("Day(s) saved to dayInfo.txt");
	}
	/*
	 * Load days info from the dayInfo.txt file into the array
	 */
	public static void loadDays() throws IOException {
		
		//create scanner for the shiftInfo text file
		String fileSeperator = System.getProperty("file.separator");
		File dayInfo = new File("Data" + fileSeperator + "dayInfo.txt");
		Scanner sc = new Scanner(dayInfo);
		//sc.useDelimiter(", |\\n|\\s");
		
		//read the information
		//check that the file isn't empty
		while(sc.hasNext() == true) {
			
			//split the next line
			String curDayInfo = sc.nextLine();
			String[] line = curDayInfo.split(" ");
			
			char dayName = ' ';
			int dayTotalNumberOfShifts = 0;
			String[] requiredShifts = new String[100];
			
			for(int i = 0; i < line.length; i++) {
				
				if(line[i].equals("Name:")) {
					dayName = line[i + 1].charAt(0);
				}
				else if(line[i].equals("Total")) {
					dayTotalNumberOfShifts = Integer.parseInt(line[i + 2]);
				}
				else if(line[i].equals("Required")) {
					
					String tempShifts = "";
					int start = i+2;
					for(int j = start; j < line.length; j++) {
						
						if(j+1 == line.length) {
							tempShifts += line[j];
						}
						else if(isInt(line[j])) {
							tempShifts += line[j] + " ";
						}
						else {
							tempShifts += line[j];
						}
						
					}
					
					String[] line2 = tempShifts.split(",");
					for(int j = 0; j < line2.length; j++) {
						requiredShifts[j] = line2[j];
					}
					
				}
				
			}
			
			Day d = new Day(dayName, dayTotalNumberOfShifts, requiredShifts);
			days[dayCounter++] = d;
			System.out.println("Loaded: " + d.getName());
			
			
		} //end while loop
		//close the scanner
		
		sc.close();
		
	}
	/*
	 * Generates an employee and saves the info to the employeeInfo.txt file
	 * public Employee(String name, Shift primaryShift, int maxHours, String[]workDays, boolean worksWeekends)
	 */
	public static void saveEmployees() throws IOException {
		
		String fileSeperator = System.getProperty("file.separator");
		//clear the file
		FileWriter fileWriter = new FileWriter("Data" + fileSeperator + "employeeInfo.txt", true);
		PrintWriter pw = new PrintWriter(fileWriter);
		
		PrintWriter clear = new PrintWriter("Data" + fileSeperator + "employeeInfo.txt");
		clear.close();
		
		for(int i = 0; i < employees.length; i++) {
			
			if(employees[i] != null) {
				
				//create string to be written to the file
				String employeeInfo = "Name: " + employees[i].getName() + " " + "Employee Number: " + employees[i].getEmployeeNum() + " " + "Max Hours: " + employees[i].getMaxHours() + " " + 
									  "Hours Worked: " + employees[i].getHoursWorked() + " " + "Primary Shift: " + employees[i].getPrimaryShift().getName() + " " + "Possible Shifts: " + 
						              employees[i].showPossibleShifts() + " " + "Can Work: " + employees[i].showWorkDays() + " " + "Works Weekends: " + employees[i].getWorksWeekends()
						              + " " + "Dates Requested Off: " + employees[i].showDatesRequestedOff() + "\n";
				
				pw.print(employeeInfo);
				
			}
			else{
				break;
			}
		}
		pw.close();
		fileWriter.close();
		System.out.println("Employee(s) saved to employeeInfo.txt");
		
	}
	/*
	 * Turns an array into a string seperated by spaces
	 */
	public static String arrayToString(Object[] o) {
		
		int fullCounter = 0;
		for(int i = 0; i < o.length; i++) {
			if(o[i] != null) {
				fullCounter++;
			}
			else {
				break;
			}
		}
		String s = "";
		for(int i = 0; i < fullCounter; i++) {
			if(i + 1 != fullCounter) {
				s += o[i].toString() + ", ";
			}
			else {
				s+= o[i].toString();
			}
		}
		return s;
	}
	
	public static boolean isInt(String s) {
		
	    if (s == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
