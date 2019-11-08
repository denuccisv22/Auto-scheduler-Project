package scheduler;

public class Employee {

	//Employee variables
	private Shift primaryShift;
	private Shift[] possibleShifts = new Shift[10];
	
	private int maxHours;
	private int hoursWorked = 0;
	
	private int[] datesRequestedOff = new int[7];
	
	private String name = "N/A";
	
	private String[] workDays = new String[7];
	
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
	public Employee(String name, Shift primaryShift, int maxHours, String[]workDays) {
		
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
	public Employee(String name, Shift primaryShift, int maxHours, String[]workDays, boolean worksWeekends) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setWorkDays(workDays);
		this.setWorksWeekends(worksWeekends);
		
	}

	public Employee(String name, Shift primaryShift, int maxHours, String[]workDays, boolean worksWeekends, Shift[] possibleShifts) {
		
		this.setName(name);
		this.setPrimaryShift(primaryShift);
		this.setMaxHours(maxHours);
		this.setWorkDays(workDays);
		this.setWorksWeekends(worksWeekends);
		this.setPossibleShifts(possibleShifts);
		
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
	public  String[] getWorkDays() {
		return workDays;
	}
	public  void setWorkDays(String[] workDays) {
		this.workDays = workDays;
	}
	public  boolean isWorksWeekends() {
		return worksWeekends;
	}
	public void setWorksWeekends(boolean worksWeekends) {
		this.worksWeekends = worksWeekends;
	}
}
