package scheduler;

public class Week {
	
	Day[] weeksDays = new Day[7];
	
	public Week() {
		
	}
	
	public Week(int weekLength) {
		
		this.weeksDays = new Day[weekLength];
		
	}

	public Day[] getWeeksDays() {
		return weeksDays;
	}

	public void setWeeksDays(Day[] weeksDays) {
		this.weeksDays = weeksDays;
	}
}
