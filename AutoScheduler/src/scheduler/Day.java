package scheduler;

public class Day {
	
	//variables for the Day class
	private char name;
	
	private int date = 0;
	private int totalNumberOfShifts = 10;
	private String[] requiredShifts = new String[100];
	
	//constructors for the Day class
	public Day(char name) {
		
		this.setName(name);
		
	}
	public Day(char name, int totalNumberOfShifts) {
		
		this.setName(name);
		this.setTotalNumberOfShifts(totalNumberOfShifts);
		this.setRequiredShifts(new String[totalNumberOfShifts]);
		
	}
	public Day(char name, int totalNumberOfShifts, String[] requiredShifts) {
		
		this.setName(name);
		this.setTotalNumberOfShifts(totalNumberOfShifts);
		this.setRequiredShifts(requiredShifts);
	}
	
	//get and set methods for the Day class
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public int getTotalNumberOfShifts() {
		return totalNumberOfShifts;
	}
	public void setTotalNumberOfShifts(int totalNumberOfShifts) {
		this.totalNumberOfShifts = totalNumberOfShifts;
	}
	public String[] getRequiredShifts() {
		return requiredShifts;
	}
	public void setRequiredShifts(String[] requiredShifts) {
		this.requiredShifts = requiredShifts;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void printDay() {
		System.out.println("Day Name: " + this.name + " | Total Number of Shifts: " + this.totalNumberOfShifts + " | Required Shifts: " + arrayToString(this.requiredShifts));
	}
	public static String arrayToString(String[] s) {
		
		String r = "";
		int fullCounter = 0;
		for(int i = 0; i < s.length; i++) {
			if(s[i] != null) {
				fullCounter++;
			}
			else {
				break;
			}
		}
		for(int i = 0; i < fullCounter; i++) {
			if(i + 1 != fullCounter) {
				r += s[i].toString() + ", ";
			}
			else {
				r += s[i].toString();
			}
		}
		return r;
	}
	
}
