package scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	//Create an array where shifts can be loaded
	public static Shift[] shifts = new Shift[100];
	public static Day[] days = new Day[7];
	public static Employee[] employees = new Employee[100];
	
	private static int shiftCounter = 0;
	private static int dayCounter = 0;
	private static int employeeCounter = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//generate folders and files on first start up
		generateFolder();
		generateFiles();
		
		//load info into arrays
		loadShifts();
		loadDays();
		loadEmployees();
		
		//create employee and test employee save
		/*Shift[] possibleShift = {shifts[2], shifts[8]};
		Day[] workDays = {days[0], days[1], days[2], days[6]};
		int[] daysOff = {1, 2, 3, 4, 5};*/
		
		//Employee sam = new Employee("Sam", 2578, 14, 0, shifts[9], possibleShift, workDays, true, daysOff);
		//Employee lynn = new Employee("Lynn", 2580, 40, 0, shifts[9], possibleShift, workDays, true, daysOff);
		//employees[0] = sam;
		//employees[1] = lynn;
		
		
		//save info into text files
		saveDays();
		saveShifts();
		saveEmployees();
		
		Year test = new Year(2019, 'S');
		test.generateYear();
		//test.printYearWeeks();
		//test.printYearMonths();
		//createShift();
		//print the information loaded into the arrays
		/*for(int i = 0; i < shifts.length; i++) {
		
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
		
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				break;
			}
			else {
				employees[i].printEmployeeInfo();
			}
		}*/
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
	 * load employee information from the employeeInfo.txt file into the employee array
	 */
	public static void loadEmployees() throws IOException {
		
		//create scanner for the shiftInfo text file
		String fileSeperator = System.getProperty("file.separator");
		File employeeInfo = new File("Data" + fileSeperator + "employeeInfo.txt");
		Scanner sc = new Scanner(employeeInfo);
		//sc.useDelimiter(", |\\n|\\s");
		
		//read the information
		//check that the file isn't empty
		while(sc.hasNext() == true) {
			
			//split the next line
			String curDayInfo = sc.nextLine();
			String[] line = curDayInfo.split(" ");
			
			String empName = "";
			int empNum = 0;
			int empMaxHours = 0;
			int empHoursWorked = 0;
			Shift empPrimeShift = null;
			Shift[] empPossShifts = new Shift[10];
			Day[] empPossDays = new Day[7];
			boolean worksWeekends = false;
			int[] datesRequestedOff = new int[31];
			
			for(int i = 0; i < line.length; i++) {
				
				if(line[i].equals("Name:")) {
					int employeeLocation = 0;
					for(int j = 0; j < line.length; j++) {
						if(line[j].equals("Employee")) {
							employeeLocation = j;
						}
					}
					for(int j = i+1; j < employeeLocation; j++) {
						if(j + 1 < employeeLocation) {
							empName += line[j] + " ";
						}
						else {
							empName += line[j];
						}
					}
				}
				else if(line[i].equals("Number:")) {
					empNum = Integer.parseInt(line[i + 1]);
				}
				else if(line[i].equals("Max")) {
					empMaxHours = Integer.parseInt(line[i+2]);
				}
				else if(line[i].equals("Worked:")) {
					empHoursWorked = Integer.parseInt(line[i+1]);
				}
				else if(line[i].equals("Primary")) {
					String shiftName = "";
					int nameLength = 0;
					for(int j = i; j < line.length; j++) {
						if(line[j].equals("Possible")) {
							nameLength = j;
						}
					}
					for(int j = i + 2; j < nameLength; j++) {
						if(j + 1 == nameLength) {
							shiftName += line[j];
						}
						else {
							shiftName += line[j] + " ";
						}
					}
					for(int j = 0; j < shifts.length; j++) {
						if(!(shifts[j] == null)) {
							if(shiftName.equals(shifts[j].getName())) {
								empPrimeShift = shifts[j];
								break;
							}
						}
						else {
							break;
						}
					}
				}
				else if(line[i].equals("Shifts:")) {
					
					String tempShifts = "";
					int start = i+1;
					int end = 0;
					for(int j = start; j < line.length; j++) {
						if(line[j].equals("Can")) {
							end = j;
						}
					}
					for(int j = start; j < end; j++) {
						
						if(j+1 == end) {
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
					int possShiftCount = 0;
					
					for(int j = 0; j < line2.length; j++) {
						for(int k = 0; k < shifts.length; k++) {
							if(!(shifts[k] == null)) {
								if(line2[j].equals(shifts[k].getName())) {
									empPossShifts[possShiftCount++] = shifts[k];
									break;
								}
							}
							else {
								break;
							}
						}
					}
				}
				
				else if(line[i].equals("Work:")) {
					
					String tempDays = "";
					int start = i+1;
					int end = 0;
					for(int j = start; j < line.length; j++) {
						if(line[j].equals("Works")) {
							end = j;
						}
					}
					for(int j = start; j < end; j++) {
						
							tempDays += line[j];
							
					}
					
					String[] line2 = tempDays.split(",");
					int possDayCount = 0;
					
					for(int j = 0; j < line2.length; j++) {
						for(int k = 0; k < shifts.length; k++) {
							if(!(days[k] == null) && line2.length > 0) {
								if(line2[j].charAt(0) == days[k].getName()) {
									empPossDays[possDayCount++] = days[k];
									break;
								}
							}
							else {
								break;
							}
						}
					}
				}
				else if(line[i].equals("Weekends:")) {
					worksWeekends = Boolean.parseBoolean(line[i+1]);
				}
				else if(line[i].equals("Off:")) {
					String tempDaysOff = "";
					if(i+1 >= line.length) {
						System.out.println("No days requested off");
					}
					else {
						for(int j = i+1; j < line.length; j++) {
							tempDaysOff += line[j];
						}
						String[] line2 = tempDaysOff.split(",");
						for(int j = 0; j < line2.length; j++) {
							datesRequestedOff[j] = Integer.parseInt(line2[j]);
						}
					}
				}
			}
			
			Employee e = new Employee(empName, empNum, empMaxHours, empHoursWorked, empPrimeShift, empPossShifts, empPossDays, worksWeekends, datesRequestedOff);
			employees[employeeCounter++] = e;
			System.out.println("Loaded: " + e.getName());
			
		} //end while loop
		//close the scanner
		
		sc.close();
		
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
