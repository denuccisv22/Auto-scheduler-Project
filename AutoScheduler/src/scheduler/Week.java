package scheduler;

public class Week {
	
	Day[] weeksDays = new Day[7];
	
	public Week() {
		
		setWeeksDays(Main.days);
		
	}

	public Day[] getWeeksDays() {
		return weeksDays;
	}

	public void setWeeksDays(Day[] weeksDays) {
		this.weeksDays = weeksDays;
	}
}
