package scheduler;

public class Year {

	private int year = 0;
	private Day[] yearDays;
	private char startDayName = '?';
	private Day startDay = null;
	private Week[] yearWeeks = new Week[53];
	private Month[] months = new Month[12];

	public Year(int year, char startDayName) {

		setYear(year);
		setStartDayName(startDayName);

		// add all months to the array
		months[0] = new Month("January", 31);

		if (year % 4 == 0) {
			months[1] = new Month("February", 29);
			yearDays = new Day[366];
		} else {
			months[1] = new Month("February", 28);
			yearDays = new Day[365];
		}

		months[2] = new Month("March", 31);
		months[3] = new Month("April", 30);
		months[4] = new Month("May", 31);
		months[5] = new Month("June", 30);
		months[6] = new Month("July", 31);
		months[7] = new Month("August", 31);
		months[8] = new Month("September", 30);
		months[9] = new Month("October", 31);
		months[10] = new Month("November", 30);
		months[11] = new Month("December", 31);

	}

	/*
	 * We have the start Day in the year. We have an array of Days in the year. We
	 * want to generate all the days in the year and place them into the yearDay[]
	 * array. Need to find a way to set the date, then change the day to the
	 * following day of the week. Main.days[] returns the days of the week array in
	 * the main class.
	 */
	// generates the year
	public void generateYear() {

		int weekDayCounter = 0;
		int dateCounter = 0;
		int dayCounter = 0;
		int date = 1;
		int weekCounter = 0;

		// get the starting day from the main days array
		for (int i = 0; i < Main.days.length; i++) {

			if (Main.days[i].getName() == startDayName) {

				startDay = Main.days[i];
				dayCounter = i;
				break;

			}

		}

		// fill the year with dates
		for (int i = 0; i < yearDays.length; i++) {

			yearDays[i] = new Day(Main.days[dayCounter].getName(), Main.days[dayCounter].getTotalNumberOfShifts(),
					Main.days[dayCounter].getRequiredShifts());
			yearDays[i].setDate(i + 1);

			// adjust the days that are assigned from the main day array
			dayCounter++;
			if (dayCounter % 7 == 0) {
				dayCounter = 0;
			}

		}
		// organize the days into months
		// for each month
		for (int i = 0; i < months.length; i++) {

			// for each day in the month
			for (int j = 0; j < months[i].getMonthDays().length; j++) {

				months[i].getMonthDays()[j] = yearDays[dateCounter++];
				months[i].getMonthDays()[j].setDate(date++);

			}

			date = 1;

		}

		// find the first day of the year, and determine the length of the first week

		if (yearDays[0].getName() == 'M') {

			Day[] dArray = new Day[6];
			yearWeeks[0] = new Week(6);

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];

			}

			yearWeeks[0].setWeeksDays(dArray);

		} else if (yearDays[0].getName() == 'T') {

			Day[] dArray = new Day[5];
			yearWeeks[0] = new Week(5);

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];

			}

			yearWeeks[0].setWeeksDays(dArray);

		} else if (yearDays[0].getName() == 'W') {

			Day[] dArray = new Day[4];
			yearWeeks[0] = new Week(4);

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];

			}

			yearWeeks[0].setWeeksDays(dArray);

		} else if (yearDays[0].getName() == 'R') {

			Day[] dArray = new Day[3];
			yearWeeks[0] = new Week(3);

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];

			}

			yearWeeks[0].setWeeksDays(dArray);

		} else if (yearDays[0].getName() == 'F') {

			Day[] dArray = new Day[2];
			yearWeeks[0] = new Week(2);

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];

			}

			yearWeeks[0].setWeeksDays(dArray);

		} else if (yearDays[0].getName() == 'S') {

			Day[] dArray = new Day[1];
			yearWeeks[0] = new Week(1);

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];

			}

			yearWeeks[0].setWeeksDays(dArray);

		}

		else {

			Day[] dArray = new Day[7];
			yearWeeks[0] = new Week();

			for (int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {

				dArray[i] = yearDays[weekDayCounter++];// new Day(yearDays[i].getName(), yearDays[i].getTotalNumberOfShifts(),
										// yearDays[i].getRequiredShifts());

			}

			yearWeeks[0].setWeeksDays(dArray);

		}

		//set the days for each week
		for (int i = 1; i < yearWeeks.length; i++) {
			
			Day[] dArray = new Day[7];
			yearWeeks[i] = new Week();

			for (int j = 0; j < yearWeeks[i].getWeeksDays().length; j++) {

				if(weekDayCounter >= yearDays.length) {
					break;
				}
				
				dArray[j] = yearDays[weekDayCounter++];
				
			}
			
			yearWeeks[i].setWeeksDays(dArray);

		}
		
		//set the weed for each month
		for(int i = 0; i < months.length; i++) {
			
			months[i].calcNumWeeks();
			Week[] wArray = new Week[months[i].getNumWeeks()];
			
			for(int j = 0; j < wArray.length; j++) {
				
				if(weekCounter >= yearWeeks.length) {
					break;
				}
				
				wArray[j] = yearWeeks[weekCounter];
				weekCounter++;
				
			}
			
			months[i].setWeeks(wArray);
			
		}

	}

	public void printYearDays() {

		for (int i = 0; i < yearDays.length; i++) {
			System.out.println("Date: " + yearDays[i].getDate() + " | Day: " + yearDays[i].getName());
		}

	}
	
	public void printYearWeeks() {
		
		System.out.println("Week: 1");
		for(int i = 0; i < yearWeeks[0].getWeeksDays().length; i++) {
			
			System.out.println("Week Day: " + yearWeeks[0].getWeeksDays()[i].getName() + " | Week Date: " + yearWeeks[0].getWeeksDays()[i].getDate());
			
		}
		
		for(int i = 1; i < yearWeeks.length; i++) {
			System.out.println("Week: " + (i + 1));
			for(int j = 0; j < yearWeeks[i].getWeeksDays().length; j++) {
				
				if(yearWeeks[i].getWeeksDays()[j] == null) {
					break;
				}
				
				System.out.println("Week Day: " + yearWeeks[i].getWeeksDays()[j].getName() + " | Week Date: " + yearWeeks[i].getWeeksDays()[j].getDate());
				
			}
			
		}
		
	}
	
	public void printYearMonths() {
		
		//for every month
		for(int i = 0; i < months.length; i++) {
			
			System.out.println("Month: " + months[i].getName());
			
			for(int j = 0; j < months[i].getWeeks().length; j++) {
				
				if(months[i].getWeeks()[j] == null) {
					break;
				}
				
				for(int k = 0; k < months[i].getWeeks()[j].getWeeksDays().length; k++) {
					
					if(months[i].getWeeks()[j]==null || months[i].getWeeks()[j].getWeeksDays()[k] == null) {
						break;
					}
					//print the day information
					System.out.println("Week Day: " + months[i].getWeeks()[j].getWeeksDays()[k].getName() + " | Week Date: " + months[i].getWeeks()[j].getWeeksDays()[k].getDate());
					
				}
				
			}
			
		}
		
	}

	public char getStartDayName() {
		return startDayName;
	}

	public void setStartDayName(char startDayName) {
		this.startDayName = startDayName;
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
