package scheduler;

public class Year {
	
	private int year = 0;
	private Day[] yearDay;
	private Day startDay = null;
	private Month[] months = new Month[12];
	
	public Year(int year, Day startDay) {
		
		setYear(year);
		setStartDay(startDay);
		
		
		//add all months to the array
		months[0] = new Month("January", 31);
		
		if(year % 4 == 0) {
			months[1] = new Month("February", 29);
			yearDay = new Day[366];
		}
		else {
			months[1] = new Month("February", 28);
			yearDay = new Day[365];
		}
		
		months[2] = new Month("March", 31);
		months[3] = new Month("April", 30);
		months[4] = new Month("May", 31);
		months[5] = new Month("June", 30);
		months[6] = new Month("July", 30);
		months[7] = new Month("August", 30);
		months[8] = new Month("September", 30);
		months[9] = new Month("October", 31);
		months[10] = new Month("November", 30);
		months[11] = new Month("December", 31);
		
	}
	
	/*
	 * We have the start Day in the year. We have an array of Days in the year. We want to generate all the days in the year and place
	 * them into the yearDay[] array. Need to find a way to set the date, then change the day to the following day of the week. 
	 * Main.days[] returns the days of the week array in the main class.
	 */
	//generates the year
	public void generateYear() {
		
		
		
	}

	public Day getStartDay() {
		return startDay;
	}

	public void setStartDay(Day startDay) {
		this.startDay = startDay;
	}

	public Month[] getMonths() {
		return months;
	}

	public void setMonths(Month[] months) {
		this.months = months;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
