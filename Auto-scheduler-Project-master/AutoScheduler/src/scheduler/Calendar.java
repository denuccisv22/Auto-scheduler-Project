package scheduler;

public class Calendar {

	//variables for the Calendar class
	private String yearName;
	private String monthName;
	
	private int numDays = 31;
	
	private Day[] days = new Day[31];
	
	//constructors for the Calendar class
	public Calendar(String yearName, String monthName) {
		
		this.setYearName(yearName);
		this.setMonthName(monthName);
		
	}
	public Calendar(String yearName, String monthName, int numDays) {
		
		this.setYearName(yearName);
		this.setMonthName(monthName);
		this.setNumDays(numDays);
		this.setDays(new Day[this.getNumDays()]);
		
	}
	
	//getters and setters for the Calendar class
	public String getYearName() {
		return yearName;
	}
	public void setYearName(String yearName) {
		this.yearName = yearName;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public int getNumDays() {
		return numDays;
	}
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	public Day[] getDays() {
		return days;
	}
	public void setDays(Day[] days) {
		this.days = days;
	}
}
