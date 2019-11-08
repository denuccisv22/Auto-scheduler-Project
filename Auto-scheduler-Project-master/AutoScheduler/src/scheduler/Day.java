package scheduler;

public class Day {
	
	//variables for the Day class
	private String name;
	
	private int totalNumberOfShifts = 10;
	private int[] requiredShifts = new int[10];
	
	//constructors for the Day class
	public Day(String name) {
		
		this.setName(name);
		
	}
	public Day(String name, int totalNumberOfShifts) {
		
		this.setName(name);
		this.setTotalNumberOfShifts(totalNumberOfShifts);
		this.setRequiredShifts(new int[totalNumberOfShifts]);
		
	}
	public Day(String name, int totalNumberOfShifts, int[] requiredShifts) {
		
		this.setName(name);
		this.setTotalNumberOfShifts(totalNumberOfShifts);
		this.setRequiredShifts(requiredShifts);
	}
	
	//get and set methods for the Day class
	public String getName() {
		return name;
	}
	public  void setName(String name) {
		this.name = name;
	}
	public int getTotalNumberOfShifts() {
		return totalNumberOfShifts;
	}
	public void setTotalNumberOfShifts(int totalNumberOfShifts) {
		this.totalNumberOfShifts = totalNumberOfShifts;
	}
	public int[] getRequiredShifts() {
		return requiredShifts;
	}
	public void setRequiredShifts(int[] requiredShifts) {
		this.requiredShifts = requiredShifts;
	}
	
}
