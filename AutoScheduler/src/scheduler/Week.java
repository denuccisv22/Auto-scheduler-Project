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
	
	/*
	 * Generates the schedule for a week
	 */
	public void generateWeekSchedule() {
		
		Scheduler tempSched = new Scheduler();
		for(int i = 0; i < weeksDays.length; i++) {
			if(weeksDays[i] != null) {
				tempSched.daySchedule(weeksDays[i]);
			}
			else {
				break;
			}
			
		}
		for(int i = 0; i < Main.orgShifts.size(); i++) {
			
			for(int j = 0; j < Main.orgShifts.get(i).size(); j++) {
				
				Employee tempEmp = Main.orgShifts.get(i).get(j);
				System.out.print("Name: " + tempEmp.getName() + " | Primary Shift: " + tempEmp.getPrimaryShift().getName() + " | Hours Worked: " + tempEmp.getHoursWorked() + " | Days working: ");
				tempEmp.printDaysWorking();
				
			}
		}
		for(int i = 0; i < Main.employees.length; i++) {
			
			if(Main.employees[i] != null) {
				
				Main.employees[i].resetHoursWorked();
				
			}
			else {
				break;
			}
			
		}
		
	}
	
}
