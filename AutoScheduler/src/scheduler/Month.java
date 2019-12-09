package scheduler;

public class Month {

	private String name = "N/A";
	private int totalDays = 0;
	private Day[] monthDays = new Day[this.totalDays];
	private Week[] weeks = new Week[5];
	private int numWeeks = 0;

	public Month(String name, int totalDays) {
		setName(name);
		setTotalDays(totalDays);
		for(int i = 0; i < totalDays; i++) {
			if(i % 7 == 0 && i != 0) {
				this.numWeeks++;
			}
		}
		
		if(this.totalDays == 30 || this.totalDays == 29 || this.totalDays == 28) {
			this.numWeeks++;
		}
		
		weeks = new Week[this.numWeeks]; //+ 1];
		monthDays = new Day[totalDays];

		for (int i = 0; i < weeks.length; i++) {

			weeks[i] = new Week();

		}

		setMonthDays(new Day[totalDays]);

	}
	
	public void printMonth() {

		System.out.println();
		System.out.println(this.name);

		for (int i = 0; i < monthDays.length; i++) {

			if ((i + 1) % 7 == 0) {

				System.out.print(monthDays[i].getDate() + "\n");

			}

			else {

				System.out.print(monthDays[i].getDate() + "\t");

			}

		}
		
		System.out.println();

	}
	public void calcNumWeeks() {
		
		int tempCount = 0;
		
		if(this.name == "January" && monthDays[0].getName() != 's') {
			tempCount++;
		}
		
		for(int i = 0; i < this.totalDays; i++) {
			
			if(monthDays[i].getName() == 's') {
				tempCount++;
			}
			
		}
		
		this.numWeeks = tempCount;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public Week[] getWeeks() {
		return weeks;
	}

	public void setWeeks(Week[] weeks) {
		this.weeks = weeks;
	}

	public Day[] getMonthDays() {
		return monthDays;
	}

	public void setMonthDays(Day[] monthDays) {
		this.monthDays = monthDays;
	}

	public int getNumWeeks() {
		return numWeeks;
	}

	public void setNumWeeks(int numWeeks) {
		this.numWeeks = numWeeks;
	}

}
