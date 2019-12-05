package scheduler;

public class Employee {

	//Employee variables
	private Shift primaryShift;
	private Shift[] possibleShifts = new Shift[10];
	
	private int employeeNum = 0;
	private int maxHours;
	private int hoursWorked = 0;
	
	private int[] datesRequestedOff = new int[31];
	
	private String name = "N/A";
	
	private Day[] workDays = new Day[7];
	
	private boolean worksWeekends = true;	
	
	//constructors for the Employee class
	public Employee(Shift primaryShift, int maxHours) {
		
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		
	}
	public Employee(String name, Shift primaryShift, int maxHours) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		
	}
	public Employee(String name, Shift primaryShift, int maxHours, Shift[]possibleShifts) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setPossibleShifts(possibleShifts);
		
	}
	public Employee(String name, Shift primaryShift, int maxHours, Day[]workDays) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setDatesRequestedOff(datesRequestedOff);
		this.setWorkDays(workDays);
		
	}
	public Employee(String name, Shift primaryShift, int maxHours, boolean worksWeekends) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setWorksWeekends(worksWeekends);
		
	}
	public Employee(String name, Shift primaryShift, int maxHours, Day[]workDays, boolean worksWeekends) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setWorkDays(workDays);
		this.setWorksWeekends(worksWeekends);
		
	}

	public Employee(String name, Shift primaryShift, int maxHours, Day[]workDays, boolean worksWeekends, Shift[] possibleShifts) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setWorkDays(workDays);
		this.setWorksWeekends(worksWeekends);
		this.setPossibleShifts(possibleShifts);
		
	}
	
	public Employee(String name, int eNum, int maxHours, int hoursWorked, Shift primaryShift, Shift[] possibleShifts, Day[] workDays, boolean worksWeekends, int[] datesRequestedOff) {
		
		this.setName(name);
		this.setEmployeeNum(eNum);
		this.setMaxHours(maxHours);
		this.setHoursWorked(hoursWorked);
		this.setPrimaryShift(primaryShift);
		this.setPossibleShifts(possibleShifts);
		this.setWorkDays(workDays);
		this.setWorksWeekends(worksWeekends);
		this.setDatesRequestedOff(datesRequestedOff);
	}
	
	//getters and setters for the Employee class
	public Shift getPrimaryShift() {
		return primaryShift;
	}

	public  void setPrimaryShift(Shift primaryShift) {
		this.primaryShift = primaryShift;
	}
	public  int getMaxHours() {
		return maxHours;
	}
	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}
	public  int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public  Shift[] getPossibleShifts() {
		return possibleShifts;
	}
	public  void setPossibleShifts(Shift[] possibleShifts) {
		this.possibleShifts = possibleShifts;
	}
	public  int[] getDatesRequestedOff() {
		return datesRequestedOff;
	}
	public  void setDatesRequestedOff(int[] datesRequestedOff) {
		this.datesRequestedOff = datesRequestedOff;
	}
	public  String getName() {
		return name;
	}
	public  void setName(String name) {
		this.name = name;
	}
	public  Day[] getWorkDays() {
		return workDays;
	}
	public  void setWorkDays(Day[] workDays) {
		this.workDays = workDays;
	}
	public  boolean getWorksWeekends() {
		return worksWeekends;
	}
	public void setWorksWeekends(boolean worksWeekends) {
		this.worksWeekends = worksWeekends;
	}
	public int getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String showPossibleShifts() {
		String s = "";
		int fullCounter = 0;
		for(int i = 0; i < this.possibleShifts.length; i++) {
			if(this.possibleShifts[i] != null) {
				fullCounter++;
			}
			else {
				break;
			}
		}
		for(int i = 0; i < fullCounter; i++) {
			if(i + 1 != fullCounter) {
				s += this.possibleShifts[i].getName() + ", ";
			}
			else {
				s += this.possibleShifts[i].getName();
			}
		}
		return s;
	}
	public String showDatesRequestedOff() {
		String s = "";
		int fullCounter = 0;
		for(int i = 0; i < this.datesRequestedOff.length; i++) {
			if(this.datesRequestedOff[i] != 0) {
				fullCounter++;
			}
			else {
				break;
			}
		}
		for(int i = 0; i < fullCounter; i++) {
			if(i + 1 != fullCounter) {
				s += this.datesRequestedOff[i] + ", ";
			}
			else {
				s += this.datesRequestedOff[i];
			}
		}
		return s;
	}
	public String showWorkDays() {
		String s = "";
		int fullCounter = 0;
		for(int i = 0; i < this.workDays.length; i++) {
			if(this.workDays[i] != null) {
				fullCounter++;
			}
			else {
				break;
			}
		}
		for(int i = 0; i < fullCounter; i++) {
			if(i + 1 != fullCounter) {
				s += this.workDays[i].getName() + ", ";
			}
			else {
				s += this.workDays[i].getName();
			}
		}
		return s;
	}
	public void printEmployeeInfo() {
		System.out.println("Name: " + this.name + " | Emp Num: " + this.employeeNum + " | Max Hours: " + this.maxHours + " | Hours Worked: " + this.hoursWorked + " | Primary Shift: " + 
						  this.primaryShift.getName() + " | Possible Shifts: " + showPossibleShifts() + " | Works: " + showWorkDays() + " | Works Weekends: " + this.worksWeekends + 
						  " | Dates Requested Off: " + showDatesRequestedOff());
	}
}
