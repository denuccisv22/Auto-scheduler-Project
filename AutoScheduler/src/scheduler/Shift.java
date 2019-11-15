package scheduler;

public class Shift {

	//variables for the Shift class
	private String name;
	
	private int hours;
	
	//constructors for the Shift class
	public Shift(String name, int hours) {
		
		this.setName(name);
		this.setHours(hours);
		
	}

	//getters and setters for the Shift class
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public void printShift() {
		System.out.println("Shift Name: " + this.name + " | Hours: " + this.hours);
	}
	
}
