package scheduler;

public class Month {

	private String name = "N/A";
	private int totalDays = 0;
	private Day[] monthDays = null;
	private Week[] weeks = new Week[4];
	
	public Month(String name, int totalDays) {
		
		setName(name);
		setTotalDays(totalDays);
		
		for(int i = 0; i < weeks.length; i++) {
			
			weeks[i] = new Week();
			
		}
		
		setMonthDays(new Day[totalDays]);
		
	}
	
	public void printMonth() {
		
		System.out.println("s\tM\tT\tW\tR\tF\tS");
		
		for(int i = 0; i < weeks.length; i++) {
			
			Day[] d = weeks[i].getWeeksDays();
			
			for(int j = 0; j < d.length; j++) {
				
				if(j == 6) {
					
					System.out.print(d[j].getDate() + "\n");
					
				}
				
				else {
					
					System.out.print(d[j].getDate() + "\t");
					
				}
				
			}
			
		}
		
	}
	
	public void popMonth() {
		
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
	
}
